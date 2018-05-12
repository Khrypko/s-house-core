package shouse.core.controller;

import shouse.core.api.RequestDispatcher;
import shouse.core.api.RequestProcessor;
import shouse.core.communication.Communicator;
import shouse.core.communication.Packet;
import shouse.core.communication.PacketProcessor;
import shouse.core.node.request.Request;
import shouse.core.node.response.Message;
import shouse.core.node.response.ResponseBody;
import shouse.core.node.storage.NodeStorage;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by maks on 20.12.17.ddddddd
 */
public class ControllerImpl implements Controller, RequestDispatcher{

    //TODO: add logger
    private static final Logger LOGGER = Logger.getLogger(ControllerImpl.class.getName());
    public static final String COULD_NOT_PROCESS_THE_REQUEST = "Could not process the request";

    private boolean running;
    private Set<Communicator> communicators;
    private Set<RequestProcessor> processors;
    private Set<PacketProcessor> packetProcessors;

    public ControllerImpl(Set<Communicator> communicators, Set<RequestProcessor> processors, Set<PacketProcessor> packetProcessors) {
        this.communicators = communicators;
        this.processors = processors;
        this.packetProcessors = packetProcessors;
    }

    @Override
    public void start(){
        if (!running){
            Thread thread = new Thread(this);
            thread.start();
        }

        throw new RuntimeException("ControllerImpl is already running!");
    }

    @Override
    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running){
            communicators.stream()
                    .filter(Communicator::hasNewPacket)
                    .forEach(comm -> processPacket(comm.recivePacket()));
        }
    }

    private void processPacket(Packet packet) {
        packetProcessors.stream()
                .filter(processor -> processor.isApplicable(packet))
                .findAny()
                .ifPresent( packetProcessor -> packetProcessor.processPacket(packet));
    }

    @Override
    public Message dispatchRequest(Request request){
        return processors.stream()
                .filter(processor -> processor.isApplicable(request))
                .findAny()
                .map(requestProcessor -> requestProcessor.processRequest(request))
                .orElse(couldNotProcessRequest(request));
    }

    private Message couldNotProcessRequest(Request request) {
        LOGGER.warning(COULD_NOT_PROCESS_THE_REQUEST.concat(". ").concat(request.toString()));
        return Message.error(couldNotProcess());
    }

    private ResponseBody couldNotProcess() {
        ResponseBody body = new ResponseBody();
        body.put("message", COULD_NOT_PROCESS_THE_REQUEST);
        return body;
    }
}
