package shouse.core.node.response;

/**
 * Defines structure for response
 */
public class Message {

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

    public static Message error(ResponseBody body){
        Message response = new Message();
        response.setStatus(ResponseStatus.FAILURE);
        response.setData(body);
        return response;
    }
}
