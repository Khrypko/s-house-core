package shouse.core.node.storage;

import shouse.core.loader.NodeFactory;
import shouse.core.node.Node;

import java.util.List;
import java.util.Map;

public interface NodeStorage {

    List<Node> loadNodes(Map<String, NodeFactory> blueprints);
}
