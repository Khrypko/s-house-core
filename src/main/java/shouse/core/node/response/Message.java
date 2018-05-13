package shouse.core.node.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines structure for response
 */
public class Message {

    private long nodeId;
    private ResponseStatus status;
    private Map<String, Object> data = new HashMap<>();

    public Message() {
    }

    public Message(ResponseStatus status) {
        this.status = status;
    }

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



    public void put(String key, Object value){
        data.put(key, value);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


    public static Message error(String couse){
        Message response = new Message();
        response.setStatus(ResponseStatus.FAILURE);
        response.put("error", couse);
        return response;
    }
}
