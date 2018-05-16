package shouse.core.node;

import shouse.core.communication.Packet;
import shouse.core.node.request.Request;
import shouse.core.node.response.Response;

/**
 * Core part.
 * Represents particular node. Implementations are responsible for all logic
 */
public abstract class Node {

    private int id;
    private int typeId;
    private boolean isActive;

    public Node(int id, int typeId, boolean isActive) {
        this.id = id;
        this.typeId = typeId;
        this.isActive = isActive;
    }

    public int getId(){
        return id;
    }

    public int getTypeId(){
        return typeId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public abstract NodeInfo getNodeInfo();

    public abstract Response process(Request request);

    public abstract void processPacket(Packet packet);
}
