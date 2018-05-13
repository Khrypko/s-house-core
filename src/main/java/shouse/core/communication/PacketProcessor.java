package shouse.core.communication;

/**
 * Created by Maks on 12.05.2018.
 */
public interface PacketProcessor {

    void processPacket(Packet request);

    boolean isApplicable(Packet request);

}
