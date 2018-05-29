package shouse.core.api;

import shouse.core.node.request.Request;
import shouse.core.node.response.Response;

/**
 * Created by Maks on 11.05.2018.
 * Class provides tools and logic to handle incoming requests.
 */
public interface RequestDispatcher {

    /**
     * Request handling.
     * @param request incoming request
     * @return This response could be 2 types:
     * - Information response (When outside applications needs actual information about different system states.)
     * - Action response (When outside applications wants the system do some actions. As we have asynchronous system, it can be response, that shows that action started or this action is not allowed because of reasons etc.)
     */
    Response dispatchRequest(Request request);

}
