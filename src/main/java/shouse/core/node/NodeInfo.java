package shouse.core.node;

public class NodeInfo {

    private int id;
    private String nodeTypeName;
    private NodeLocation nodeLocation;
    private String description;
    private boolean isActive;

    public NodeInfo(int id, String nodeTypeName, NodeLocation nodeLocation, String description) {
        this.id = id;
        this.nodeTypeName = nodeTypeName;
        this.nodeLocation = nodeLocation;
        this.description = description;
        this.isActive = false;
    }

    public NodeInfo(int id, String nodeTypeName, NodeLocation nodeLocation, String description, boolean isActive) {
        this.id = id;
        this.nodeTypeName = nodeTypeName;
        this.nodeLocation = nodeLocation;
        this.description = description;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeTypeName() {
        return nodeTypeName;
    }

    public void setNodeTypeName(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NodeLocation getNodeLocation() {
        return nodeLocation;
    }

    public void setNodeLocation(NodeLocation nodeLocation) {
        this.nodeLocation = nodeLocation;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "NodeInfo{" +
                "id=" + id +
                ", nodeTypeName='" + nodeTypeName + '\'' +
                ", nodeLocation=" + nodeLocation +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
