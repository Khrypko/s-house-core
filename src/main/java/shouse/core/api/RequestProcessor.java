package shouse.core.api;

import shouse.core.node.request.Request;
import shouse.core.node.response.Message;

/**
 * Should delegate processing of request to concrete node
 */
public interface RequestProcessor {

    Message processRequest(Request request);

    boolean isApplicable(Request request);

}
