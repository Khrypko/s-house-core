package shouse.core.api;

import shouse.core.node.response.Response;

import java.util.ArrayList;
import java.util.List;

public class NotifierContainer {

    List<Notifier> notifiers;

    public NotifierContainer(Notifier notifier) {
        notifiers = new ArrayList<>();
        notifiers.add(notifier);
    }

    public NotifierContainer(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void sendResponse2EveryOne(Response response){
        notifiers.stream().forEach(notifier -> notifier.sendResponse(response));
    }
}
