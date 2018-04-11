package shouse.core.node.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Wraps node response body
 */
public class ResponseBody {

    private Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value){
        data.put(key, value);
    }

}
