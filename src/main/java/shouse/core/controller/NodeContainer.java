package shouse.core.controller;

import shouse.core.node.Node;
import shouse.core.node.NodeInfo;
import shouse.core.node.storage.NodeStorage;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * Created by maks on 20.12.17.
 */
public class NodeContainer {

    private NodeStorage nodeStorage;
    private Map<Integer, Node> nodes;

    public NodeContainer(NodeStorage nodeStorage) {
        this.nodeStorage = nodeStorage;
    }

    @PostConstruct
    private void initialize() {
        this.nodes = nodeStorage.loadNodes()
                .stream()
                .collect(toMap(Node::getId, node -> node));
    }

    public Optional<Node> getNode(int id){
        return Optional.ofNullable(nodes.get(id));
    }

    public Collection<Node> getAllNodes(){
        return this.nodes.values().stream().collect(Collectors.toSet());
    }

//    public Collection<NodeInfo> getAllNodesInfo(){
//        return this.nodes.values().stream().map(Node::getNodeInfo).collect(Collectors.toSet());
//    }
//
//    public Optional<NodeInfo> getNodeInfo(int id){
//        Node node = nodes.get(id);
//        if (node != null){
//            return Optional.ofNullable(node.getNodeInfo());
//        }
//
//        return Optional.empty();
//    }


}
