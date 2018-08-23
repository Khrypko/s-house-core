package shouse.core;

import shouse.core.api.Notifier;
import shouse.core.api.RequestDispatcher;
import shouse.core.api.RequestDispatcherImpl;
import shouse.core.api.RequestProcessor;
import shouse.core.communication.NodeCommunicator;
import shouse.core.communication.PacketProcessor;
import shouse.core.controller.Controller;
import shouse.core.controller.ControllerImpl;
import shouse.core.controller.NodeContainer;
import shouse.core.loader.NodeFactory;
import shouse.core.loader.NodeLoader;
import shouse.core.node.Node;
import shouse.core.node.storage.NodeStorage;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Maks on 01.07.2018.
 */
public class SmartHouseInitializer {

    private Set<Notifier> notifiers;
    private Set<NodeCommunicator> nodeCommunicators;
    private NodeStorage nodeStorage;
    private Set<RequestProcessor> requestProcessors;
    private Set<PacketProcessor> packetProcessors;

    public SmartHouseInitializer notifiers(Set<Notifier> notifiers) {
        this.notifiers = notifiers;
        return this;
    }

    public SmartHouseInitializer communicators(Set<NodeCommunicator> nodeCommunicators) {
        this.nodeCommunicators = nodeCommunicators;
        return this;
    }

    public SmartHouseInitializer nodeStorage(NodeStorage nodeStorage){
        this.nodeStorage = nodeStorage;
        return this;
    }

    public SmartHouseInitializer requestProcessors(Set<RequestProcessor> communicators) {
        this.requestProcessors = communicators;
        return this;
    }

    public SmartHouseInitializer packetProcessors(Set<PacketProcessor> communicators) {
        this.packetProcessors = communicators;
        return this;
    }

    public SmartHouseContext initialize(){
        if (notifiersEmpty() || communicatorsEmpty() || nodeStorageNotSet()){
            throw new RuntimeException("Notifiers or nodeCommunicators are not set!");
        }

        SmartHouseContext context = new SmartHouseContext();
        context.setNodeCommunicators(nodeCommunicators);
        context.setNotifiers(notifiers);
        loadNodes(context);
        setUpNodeContainer(context);
        setUpRequestProcessors(context);
        setUpPacketProcessors(context);
        initializeController(context);

        return context;
    }

    private boolean nodeStorageNotSet() {
        return nodeStorage == null;
    }


    private boolean communicatorsEmpty() {
        return nodeCommunicators == null || nodeCommunicators.isEmpty();
    }

    private boolean notifiersEmpty() {
        return notifiers == null || notifiers.isEmpty();
    }

    private void loadNodes(SmartHouseContext context) {
        NodeLoader nodeLoader = new NodeLoader(nodeCommunicators, notifiers);
        Map<String, NodeFactory> blueprints = nodeLoader.loadNodes();
        context.setNodeBlueprints(blueprints);
    }

    private void setUpNodeContainer(SmartHouseContext context) {
        List<Node> nodes = nodeStorage.loadNodes(context.getNodeBlueprints());
        NodeContainer nodeContainer = new NodeContainer(nodes);
        context.setNodeContainer(nodeContainer);
    }

    private void setUpRequestProcessors(SmartHouseContext context) {
        Set<RequestProcessor> processors = context.getNodeBlueprints().values().stream()
                .map(factory -> factory.getRequestProcessor(context.getNodeContainer()) )
                .collect(Collectors.toSet());
        if (this.requestProcessors != null) processors.addAll(this.requestProcessors);
        context.setRequestProcessors(processors);

        RequestDispatcher dispatcher = new RequestDispatcherImpl(processors);
        context.setDispatcher(dispatcher);
    }

    private void setUpPacketProcessors(SmartHouseContext context) {
        Set<PacketProcessor> processors = context.getNodeBlueprints().values().stream()
                .map(factory -> factory.getPacketProcessor(context.getNodeContainer()) )
                .collect(Collectors.toSet());
        if (this.packetProcessors != null) processors.addAll(this.packetProcessors);
        context.setPacketProcessors(processors);
    }

    private void initializeController(SmartHouseContext context) {
        Controller controller = new ControllerImpl(nodeCommunicators, context.getPacketProcessors());
        context.setController(controller);
    }

}
