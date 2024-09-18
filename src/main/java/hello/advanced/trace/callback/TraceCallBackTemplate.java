package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public class TraceCallBackTemplate {
    private final LogTrace logTrace;

    public TraceCallBackTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) throws IllegalAccessException {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);
            T result = callback.call();
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
