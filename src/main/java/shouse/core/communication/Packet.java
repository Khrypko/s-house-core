package shouse.core.communication;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Defines structure for packet, that is used for exchange between system and hardware
 */
public class Packet {

    private int nodeId;
    private Map<String, String> data;

    public Packet(int nodeId) {
        this.nodeId = nodeId;
        this.data = new LinkedHashMap<>();
    }

    public int getNodeId(){
        return nodeId;
    }

    public Map<String, String> getData(){
        return data;
    }

    public void putData(String key, String val){
        this.data.put(key, val);
    }

}
