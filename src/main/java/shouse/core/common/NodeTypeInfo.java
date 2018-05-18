package shouse.core.common;

public class NodeTypeInfo {

    private int nodeTypeId;
    private String nodeTypeName;

    public NodeTypeInfo(int nodeTypeId, String nodeTypeName) {
        this.nodeTypeId = nodeTypeId;
        this.nodeTypeName = nodeTypeName;
    }

    public int getNodeTypeId() {
        return nodeTypeId;
    }

    public void setNodeTypeId(int nodeTypeId) {
        this.nodeTypeId = nodeTypeId;
    }

    public String getNodeTypeName() {
        return nodeTypeName;
    }

    public void setNodeTypeName(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
    }
}
