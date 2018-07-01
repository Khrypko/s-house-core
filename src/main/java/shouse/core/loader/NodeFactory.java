package shouse.core.loader;

import shouse.core.api.Notifier;
import shouse.core.api.RequestProcessor;
import shouse.core.communication.Communicator;
import shouse.core.communication.PacketProcessor;
import shouse.core.controller.NodeContainer;
import shouse.core.node.Node;

import java.util.Map;
import java.util.Set;

/**
 * Created by Maks on 01.07.2018.
 */
public interface NodeFactory {

    Node createNode(Map<String, Object> details);

    RequestProcessor getRequestProcessor(NodeContainer nodeContainer);

    PacketProcessor getPacketProcessor(NodeContainer nodeContainer);

    String getTypeName();

    void setCommunicators(Set<Communicator> communicators);

    void setNotifiers(Set<Notifier> notifiers);

}
