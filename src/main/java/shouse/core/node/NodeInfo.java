package shouse.core.node;

public class NodeInfo {

    private int id;
    private int nodeTypeId;
    private int nodeLocationId;
    private String description;
    private boolean isActive;

    public NodeInfo(int id, int nodeTypeId, int nodeLocationId, String description) {
        this.id = id;
        this.nodeTypeId = nodeTypeId;
        this.nodeLocationId = nodeLocationId;
        this.description = description;
        this.isActive = false;
    }

    public NodeInfo(int id, int nodeTypeId, int nodeLocationId, String description, boolean isActive) {
        this.id = id;
        this.nodeTypeId = nodeTypeId;
        this.nodeLocationId = nodeLocationId;
        this.description = description;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNodeTypeId() {
        return nodeTypeId;
    }

    public void setNodeTypeId(int nodeTypeId) {
        this.nodeTypeId = nodeTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNodeLocationId() {
        return nodeLocationId;
    }

    public void setNodeLocationId(int nodeLocationId) {
        this.nodeLocationId = nodeLocationId;
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
                ", nodeTypeId=" + nodeTypeId +
                ", nodeLocationId=" + nodeLocationId +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
