package shouse.core.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shouse.core.controller.NodeContainer;

/**
 * Created by Maks on 01.07.2018.
 */
public class DefaultPacketProcessor implements PacketProcessor {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final String nodeTypeName;
    private NodeContainer nodeContainer;

    public DefaultPacketProcessor(String nodeTypeName, NodeContainer nodeContainer) {
        this.nodeTypeName = nodeTypeName;
        this.nodeContainer = nodeContainer;
    }

    @Override
    public void processPacket(Packet packet) {
        nodeContainer.getNode(packet.getNodeId()).ifPresent(node -> node.processPacket(packet));
    }

    @Override
    public boolean isApplicable(Packet packet) {
        if(packet.getData().get(Packet.NODE_TYPE_NAME).equals(nodeTypeName)) {
            LOGGER.info("isApplicable. true. packet: " + packet);
            return true;
        }

        LOGGER.info("isApplicable. false. packet: " + packet);
        return false;
    }
}
