package shouse.core.communication;

/**
 * Hides communication between system and hardware
 */
public interface NodeCommunicator {

    void sendPacket(Packet packet);

    Packet receivePacket();

    boolean hasNewPacket();

}
