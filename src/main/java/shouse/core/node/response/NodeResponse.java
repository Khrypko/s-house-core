package shouse.core.node.response;

/**
 * Defines structure for response
 */
public class NodeResponse {

    private long nodeId;
    private ResponseStatus status;
    private ResponseBody data;

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public ResponseBody getData() {
        return data;
    }

    public void setData(ResponseBody data) {
        this.data = data;
    }
}
