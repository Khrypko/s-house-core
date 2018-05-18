package shouse.core.common;

public class NodeLocationInfo {

    private int nodeLocationId;
    private String nodeLocationName;

    public NodeLocationInfo(int nodeLocationId, String nodeLocationName) {
        this.nodeLocationId = nodeLocationId;
        this.nodeLocationName = nodeLocationName;
    }

    public int getNodeLocationId() {
        return nodeLocationId;
    }

    public void setNodeLocationId(int nodeLocationId) {
        this.nodeLocationId = nodeLocationId;
    }

    public String getNodeLocationName() {
        return nodeLocationName;
    }

    public void setNodeLocationName(String nodeLocationName) {
        this.nodeLocationName = nodeLocationName;
    }
}
