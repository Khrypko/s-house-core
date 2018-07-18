package shouse.core.node.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines structure for response
 */
public class Response {

    private ResponseStatus status;
    private Map<String, Object> data = new HashMap<>();

    public Response() {}

    public Response(ResponseStatus status) {
        this.status = status;
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

    public static Response error(String couse){
        Response response = new Response();
        response.setStatus(ResponseStatus.FAILURE);
        response.put("error", couse);
        return response;
    }

    @Override
    public String toString() {
        return "Response{" +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
