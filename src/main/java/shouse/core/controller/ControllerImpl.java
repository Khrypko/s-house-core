package shouse.core.controller;

import shouse.core.communication.NodeCommunicator;
import shouse.core.communication.Packet;
import shouse.core.communication.PacketProcessor;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by maks on 20.12.17
 */
public class ControllerImpl implements Controller{
    private static final Logger log = Logger.getLogger(ControllerImpl.class.getName());

    private boolean running;
    private Set<NodeCommunicator> nodeCommunicators;
    private Set<PacketProcessor> packetProcessors;

    public ControllerImpl(Set<NodeCommunicator> nodeCommunicators, Set<PacketProcessor> packetProcessors) {
        this.nodeCommunicators = nodeCommunicators;
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
        log.info("Nodes packets processor is running.");
        running = true;
        while (running){
            nodeCommunicators.stream()
                    .filter(NodeCommunicator::hasNewPacket)
                    .forEach(comm -> processPacket(comm.receivePacket()));
        }
    }

    private void processPacket(Packet packet) {
        log.info("Packet received.");
        packetProcessors.stream()
                .filter(processor -> processor.isApplicable(packet))
                .findAny()
                .ifPresent( packetProcessor -> packetProcessor.processPacket(packet));
    }

}
