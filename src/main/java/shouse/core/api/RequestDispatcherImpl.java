package shouse.core.api;

import shouse.core.node.request.Request;
import shouse.core.node.response.Message;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Maks on 12.05.2018.
 */
public class RequestDispatcherImpl implements RequestDispatcher {

    private static final Logger LOGGER = Logger.getLogger(RequestDispatcherImpl.class.getName());
    private static final String COULD_NOT_PROCESS_THE_REQUEST = "Could not process the request";

    private Set<RequestProcessor> processors;

    public RequestDispatcherImpl(Set<RequestProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public Message dispatchRequest(Request request){
        return processors.stream()
                .filter(processor -> processor.isApplicable(request))
                .findAny()
                .map(requestProcessor -> requestProcessor.processRequest(request))
                .orElseGet(() -> couldNotProcessRequest(request));
    }

    private Message couldNotProcessRequest(Request request) {
        LOGGER.warning(COULD_NOT_PROCESS_THE_REQUEST.concat(". ").concat(request.toString()));
        return Message.error(COULD_NOT_PROCESS_THE_REQUEST);
    }

}
