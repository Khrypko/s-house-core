package shouse.core.controller;

import shouse.core.communication.Communicator;
import shouse.core.communication.Packet;
import shouse.core.communication.PacketProcessor;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by maks on 20.12.17
 */
public class ControllerImpl implements Controller{

    //TODO: add logger
    private static final Logger LOGGER = Logger.getLogger(ControllerImpl.class.getName());

    private boolean running;
    private Set<Communicator> communicators;
    private Set<PacketProcessor> packetProcessors;

    public ControllerImpl(Set<Communicator> communicators, Set<PacketProcessor> packetProcessors) {
        this.communicators = communicators;
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
                    .forEach(comm -> processPacket(comm.receivePacket()));
        }
    }

    private void processPacket(Packet packet) {
        packetProcessors.stream()
                .filter(processor -> processor.isApplicable(packet))
                .findAny()
                .ifPresent( packetProcessor -> packetProcessor.processPacket(packet));
    }

}
