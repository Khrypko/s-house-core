package shouse.core.communication;

/**
 * Hides communication between system and hardware
 */
public interface Communicator {

    void sendPacket(Packet packet);

    Packet receivePacket();

    boolean hasNewPacket();

}
