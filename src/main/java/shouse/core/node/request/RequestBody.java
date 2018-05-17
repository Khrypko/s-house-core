package shouse.core.node.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maks on 12.04.2018.
 */
public class RequestBody {

    private Map<String, String> parameters;

    public String getParameter(String paramName){
        return parameters.get(paramName);
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "parameters=" + parameters +
                '}';
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(String paramKey, String paramValue){
        parameters = new HashMap<>();
        parameters.put(paramKey, paramValue);
    }
}
