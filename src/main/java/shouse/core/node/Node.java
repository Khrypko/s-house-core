package shouse.core.node;

import shouse.core.communication.Packet;
import shouse.core.node.request.Request;
import shouse.core.node.response.Message;

/**
 * Core part.
 * Represents particular node. Implementations are responsible for all logic
 */
public interface Node {

    int getId();

    NodeInfo getNodeInfo();

    Message process(Request request);

    void update(Packet packet);

}
