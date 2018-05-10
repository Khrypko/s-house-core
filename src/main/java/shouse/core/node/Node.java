package shouse.core.node;

import shouse.core.communication.Packet;
import shouse.core.node.request.NodeRequest;
import shouse.core.node.response.Message;

/**
 * Core part.
 * Represents particular node. Implementations are responsible for all logic
 */
public interface Node {

    Message process(NodeRequest request);

    void update(Packet packet);

}
