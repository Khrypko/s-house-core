package shouse.core.node.request;

import shouse.core.api.Notifier;

/**
 * Represents request format
 */
public class Request {

    private long nodeId;
    private Notifier notifier;
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

    public Notifier getNotifier() {
        return notifier;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }
}
