package shouse.core.api;

import shouse.core.node.response.Message;

/**
 * Created by Maks on 11.05.2018.
 */
public interface Notifier {

    void sendResponse(Message message);

}
