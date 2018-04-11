package shouse.core.node.request;

/**
 * Represents request format
 */
public class NodeRequest {

    private long nodeId;
    private RequestBody body;

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }
}
