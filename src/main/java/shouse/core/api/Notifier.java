package shouse.core.api;

import shouse.core.node.response.Response;

/**
 * Created by Maks on 11.05.2018.
 */
public interface Notifier {

    void sendResponse(Response response);

}
