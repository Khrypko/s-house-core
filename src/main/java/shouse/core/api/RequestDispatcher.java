package shouse.core.api;

import shouse.core.node.request.NodeRequest;
import shouse.core.node.response.Message;

/**
 * Created by Maks on 11.05.2018.
 */
public interface RequestDispatcher {

    Message processRequest(NodeRequest nodeRequest);

}
