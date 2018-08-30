package shouse.core.node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shouse.core.api.Notifier;
import shouse.core.common.SystemConstants;
import shouse.core.communication.NodeCommunicator;
import shouse.core.communication.Packet;
import shouse.core.node.request.Request;
import shouse.core.node.response.Response;
import shouse.core.node.response.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Core part.
 * Represents particular node. Implementations are responsible for all logic
 */
public abstract class Node {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private int id;
    private NodeLocation nodeLocation;
    private String typeName;
    private boolean isActive;
    private LocalDateTime lastAliveDate;
    private NodeCommunicator nodeCommunicator;
    private List<Notifier> notifiers;
    private String description;


    public Node(int id, NodeLocation nodeLocation, NodeCommunicator nodeCommunicator, List<Notifier> notifiers, String description) {
        this.id = id;
        this.nodeLocation = nodeLocation;
        this.isActive = false;
        this.nodeCommunicator = nodeCommunicator;
        this.notifiers = notifiers;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public String getTypeName(){
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public abstract NodeInfo getNodeInfo();

    public abstract Response processRequest(Request request);

    public abstract void processPacket(Packet packet);

    public NodeLocation getNodeLocation() {
        return nodeLocation;
    }

    public LocalDateTime getLastAliveDate() {
        return lastAliveDate;
    }

    public void setLastAliveDate(LocalDateTime lastAliveDate) {
        this.lastAliveDate = lastAliveDate;
    }

    public NodeCommunicator getNodeCommunicator() {
        return nodeCommunicator;
    }

    public List<Notifier> getNotifiers() {
        return notifiers;
    }

    public String getDescription() {
        return description;
    }

    public Response nodeIsNotActiveResponse(){
        LOGGER.error("Request processing fail. Node is not active.");
        Response response = new Response();
        response.setStatus(ResponseStatus.FAILURE);
        response.put(SystemConstants.failureMessage, "Node is not active.");
        return response;
    }
}
