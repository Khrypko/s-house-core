package shouse.core.controller;

import shouse.core.node.Node;
import shouse.core.node.storage.NodeStorage;

import java.util.Optional;

/**
 * Created by maks on 20.12.17.
 */
public class NodeContainer {

    private NodeStorage nodeStorage;

    public NodeContainer(NodeStorage nodeStorage) {
        this.nodeStorage = nodeStorage;
        initialize();
    }

    private void initialize() {
        //TODO
    }

    public Optional<Node> getNode(Long id){
        return  null;
    }


}
