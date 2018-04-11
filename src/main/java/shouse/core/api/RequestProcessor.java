package shouse.core.api;

import shouse.core.node.request.NodeRequest;
import shouse.core.node.response.NodeResponse;

/**
 * Should delegate processing of request to concrete node
 */
public interface RequestProcessor {

    NodeResponse processRequest(NodeRequest nodeRequest);

}
