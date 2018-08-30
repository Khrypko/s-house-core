package shouse.core.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shouse.core.controller.NodeContainer;
import shouse.core.node.request.Request;
import shouse.core.node.response.Response;

/**
 * Created by Maks on 01.07.2018.
 */
public class DefaultRequestProcessor implements RequestProcessor{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final String nodeTypeName;
    private NodeContainer nodeContainer;

    public DefaultRequestProcessor(String nodeTypeName, NodeContainer nodeContainer) {
        this.nodeTypeName = nodeTypeName;
        this.nodeContainer = nodeContainer;
    }

    @Override
    public Response processRequest(Request request) {
        return nodeContainer.getNode(getNodeIdFromRequest(request))
                .map(node -> node.processRequest(request))
                .orElse(nodeNotFoundResponse());
    }

    private Response nodeNotFoundResponse() {
        return Response.error("Could not find node with specified id!");
    }

    private int getNodeIdFromRequest(Request request) {
        return Integer.parseInt(request.getBody().getParameter(Request.NODE_ID));
    }

    @Override
    public boolean isApplicable(Request request) {
        String typeName = request.getBody().getParameter(Request.NODE_TYPE_NAME);
        if(typeName != null && typeName.equals(nodeTypeName)) {
            LOGGER.info("isApplicable: true");
            return true;
        }

        return false;
    }
}
