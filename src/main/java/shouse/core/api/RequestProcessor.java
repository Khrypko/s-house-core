package shouse.core.api;

import shouse.core.node.request.NodeRequest;
import shouse.core.node.response.Message;

/**
 * Should delegate processing of request to concrete node
 */
public interface RequestProcessor {

    Message processRequest(NodeRequest nodeRequest);

    boolean isApplicable(NodeRequest nodeRequest);

}
