package shouse.core.controller;

import shouse.core.node.Node;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by maks on 20.12.17.
 */
public class NodeContainer {

    private Map<Integer, Node> nodes;

    public NodeContainer(List<Node> nodes) {
        this.nodes = nodes.stream().collect(Collectors.toMap(Node::getId, node -> node));
    }

    public Optional<Node> getNode(int id){
        return Optional.ofNullable(nodes.get(id));
    }

    public Collection<Node> getAllNodes(){
        return this.nodes.values().stream().collect(Collectors.toSet());
    }


}
