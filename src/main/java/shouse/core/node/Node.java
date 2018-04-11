package shouse.core.node;

import shouse.core.communication.Packet;
import shouse.core.node.request.NodeRequest;
import shouse.core.node.response.NodeResponse;

/**
 * Core part.
 * Represents particular node. Implementations are responsible for all logic
 */
public interface Node {

    NodeResponse process(NodeRequest request);

    void update(Packet packet);

}
