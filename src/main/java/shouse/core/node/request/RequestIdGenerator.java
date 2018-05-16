package shouse.core.node.request;

public class RequestIdGenerator {

    private static long requestId = 0;

    public static long generateId() {
        return requestId++;
    }

}
