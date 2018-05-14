package shouse.core.node;

import shouse.core.communication.Packet;
import shouse.core.node.request.Request;
import shouse.core.node.response.Message;

/**
 * Core part.
 * Represents particular node. Implementations are responsible for all logic
 */
public abstract class Node {

    private int id;
    private int typeId;

    public Node(int id, int typeId) {
        this.id = id;
        this.typeId = typeId;
    }

    public int getId(){
        return id;
    };

    public int getTypeId(){
        return typeId;
    };

    public abstract NodeInfo getNodeInfo();

    public abstract Message process(Request request);

    public abstract void update(Packet packet);

}
