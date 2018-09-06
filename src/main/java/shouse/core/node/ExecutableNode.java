package shouse.core.node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shouse.core.api.Notifier;
import shouse.core.common.SystemConstants;
import shouse.core.communication.NodeCommunicator;
import shouse.core.node.response.Response;
import shouse.core.node.response.ResponseStatus;

import java.util.List;

public abstract class ExecutableNode extends Node{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private boolean hasControlCommand;

    public ExecutableNode(int id, NodeLocation nodeLocation, NodeCommunicator nodeCommunicator, List<Notifier> notifiers, String description) {
        super(id, nodeLocation, nodeCommunicator, notifiers, description);
        this.hasControlCommand = false;
    }

    public boolean isHasControlCommand() {
        return hasControlCommand;
    }

    public void setHasControlCommand(boolean hasControlCommand) {
        this.hasControlCommand = hasControlCommand;
    }

    public Response alreadyHasControlCommand(){
        LOGGER.error("Request processing fail. Node already has control command.");
        Response response = new Response();
        response.setStatus(ResponseStatus.FAILURE);
        response.put(SystemConstants.failureMessage, "Node already has control command.");
        return response;
    }
}
