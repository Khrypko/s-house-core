package shouse.core;

import shouse.core.api.Notifier;
import shouse.core.api.RequestDispatcher;
import shouse.core.api.RequestProcessor;
import shouse.core.communication.NodeCommunicator;
import shouse.core.communication.PacketProcessor;
import shouse.core.controller.Controller;
import shouse.core.controller.NodeContainer;
import shouse.core.loader.NodeFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Maks on 01.07.2018.
 */
public class SmartHouseContext {

    private RequestDispatcher dispatcher;
    private Set<RequestProcessor> requestProcessors;
    private Set<Notifier> notifiers;

    private Set<PacketProcessor> packetProcessors;
    private Set<NodeCommunicator> nodeCommunicators;

    private Controller controller;
    private NodeContainer nodeContainer;

    private Map<String, NodeFactory> nodeBlueprints;

    public RequestDispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(RequestDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public Set<RequestProcessor> getRequestProcessors() {
        return requestProcessors;
    }

    public void setRequestProcessors(Set<RequestProcessor> requestProcessors) {
        this.requestProcessors = requestProcessors;
    }

    public void addRequestProcessor(RequestProcessor requestProcessor){
        if (this.requestProcessors == null) this.requestProcessors = new HashSet<>();

        requestProcessors.add(requestProcessor);
    }

    public Set<Notifier> getNotifiers() {
        return notifiers;
    }

    public void setNotifiers(Set<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public Set<PacketProcessor> getPacketProcessors() {
        return packetProcessors;
    }

    public void setPacketProcessors(Set<PacketProcessor> packetProcessors) {
        this.packetProcessors = packetProcessors;
    }

    public void addPacketProcessor(PacketProcessor processor){
        if (this.packetProcessors == null) packetProcessors = new HashSet<>();

        packetProcessors.add(processor);
    }

    public Set<NodeCommunicator> getNodeCommunicators() {
        return nodeCommunicators;
    }

    public void setNodeCommunicators(Set<NodeCommunicator> nodeCommunicators) {
        this.nodeCommunicators = nodeCommunicators;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public NodeContainer getNodeContainer() {
        return nodeContainer;
    }

    public void setNodeContainer(NodeContainer nodeContainer) {
        this.nodeContainer = nodeContainer;
    }

    public Map<String, NodeFactory> getNodeBlueprints() {
        return nodeBlueprints;
    }

    public void setNodeBlueprints(Map<String, NodeFactory> nodeBlueprints) {
        this.nodeBlueprints = nodeBlueprints;
    }
}
