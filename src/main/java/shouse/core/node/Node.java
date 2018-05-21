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
    private NodeLocation nodeLocation;
    private String typeName;
    private boolean isActive;

    public Node(int id, NodeLocation nodeLocation) {
        this.id = id;
        this.nodeLocation = nodeLocation;
        this.isActive = false;
    }

    public int getId(){
        return id;
    }

    public String getTypeName(){
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public NodeLocation getNodeLocation() {
        return nodeLocation;
    }
}
