package shouse.core.node;

public class NodeLocation {

    private int nodeLocationId;
    private String nodeLocationName;

    public NodeLocation(int nodeLocationId, String nodeLocationName) {
        this.nodeLocationId = nodeLocationId;
        this.nodeLocationName = nodeLocationName;
    }

    public int getNodeLocationId() {
        return nodeLocationId;
    }

    public String getNodeLocationName() {
        return nodeLocationName;
    }

    @Override
    public String toString() {
        return "NodeLocation{" +
                "nodeLocationId=" + nodeLocationId +
                ", nodeLocationName='" + nodeLocationName + '\'' +
                '}';
    }
}
