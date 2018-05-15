package shouse.core.api;

import shouse.core.node.request.Request;
import shouse.core.node.response.Response;

/**
 * Should delegate processing of request to concrete node
 */
public interface RequestProcessor {

    Response processRequest(Request request);

    boolean isApplicable(Request request);

}
