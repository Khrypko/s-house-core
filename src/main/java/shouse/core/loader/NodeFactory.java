package shouse.core.loader;

import shouse.core.api.Notifier;
import shouse.core.api.RequestProcessor;
import shouse.core.communication.NodeCommunicator;
import shouse.core.communication.PacketProcessor;
import shouse.core.controller.NodeContainer;
import shouse.core.node.Node;

import java.util.Set;

/**
 * Created by Maks on 01.07.2018.
 */
public interface NodeFactory<T> {

    Node createNode(T details);

    Node createNode();

    RequestProcessor getRequestProcessor(NodeContainer nodeContainer);

    PacketProcessor getPacketProcessor(NodeContainer nodeContainer);

    String getTypeName();

    void setNodeCommunicators(Set<NodeCommunicator> nodeCommunicators);

    void setNotifiers(Set<Notifier> notifiers);

}
