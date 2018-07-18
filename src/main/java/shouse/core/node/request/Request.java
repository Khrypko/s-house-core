package shouse.core.node.request;

import shouse.core.api.Notifier;

import java.util.Map;

/**
 * Represents request format
 */
public class Request {

    private Notifier notifier;
    private RequestBody body;

    public Request () {}

    public Request (String paramKey, String paramValue){
        body = new RequestBody();
        body.addParameter(paramKey, paramValue);
    }

    public Request (Map<String,String> params){
        body = new RequestBody();
        body.setParameters(params);
    }

    public void addParameter(String paramKey, String paramValue){
        if(body == null)
            body = new RequestBody();

        body.addParameter(paramKey, paramValue);
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }

    public Notifier getNotifier() {
        return notifier;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public String toString() {
        return "Request{" +
                ", body=" + body.toString() +
                '}';
    }
}
