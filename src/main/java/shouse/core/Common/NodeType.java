package shouse.core.Common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum NodeType {
    POWER_SOCKET (101, "Power socket"),
    LIGHT (100, "Light");

    private int id;
    private String name;

    NodeType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static NodeType getNodeTypeById(int nodeTypeId){
        return Arrays.stream(NodeType.values()).filter(nodeType -> nodeType.id == nodeTypeId).findFirst().get();
    }

    public static NodeType getNodeTypeByDescription(String description){
        return Arrays.stream(NodeType.values()).filter(nodeType -> nodeType.name.equals(description)).findFirst().get();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<NodeTypeWrapper> getTypes(){
        return Arrays.asList(values()).stream().map(e -> new NodeTypeWrapper(e.id, e.name)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "NodeType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
