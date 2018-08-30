package shouse.core.api;

import shouse.core.node.request.Request;
import shouse.core.node.response.Response;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Maks on 12.05.2018.
 */
public class RequestDispatcherImpl implements RequestDispatcher {

    private static final Logger LOGGER = Logger.getLogger(RequestDispatcherImpl.class.getName());
    private static final String COULD_NOT_PROCESS_THE_REQUEST = "Could not processRequest the request";

    private Set<RequestProcessor> processors;

    public RequestDispatcherImpl(Set<RequestProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public Response dispatchRequest(Request request){
        LOGGER.info("Start processRequest request: ".concat(request.toString()));
        return processors.stream()
                .filter(processor -> processor.isApplicable(request))
                .findAny()
                .map(requestProcessor -> requestProcessor.processRequest(request))
                .orElseGet(() -> couldNotProcessRequest(request));
    }

    private Response couldNotProcessRequest(Request request) {
        LOGGER.warning(COULD_NOT_PROCESS_THE_REQUEST.concat(". ").concat(request.toString()));
        return Response.error(COULD_NOT_PROCESS_THE_REQUEST);
    }

}
