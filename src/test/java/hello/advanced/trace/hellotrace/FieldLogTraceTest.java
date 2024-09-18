package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.FieldLogTrace;
import org.junit.jupiter.api.Test;

public class FieldLogTraceTest {

    FieldLogTrace trace1 = new FieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace1.begin("hello1");
        TraceStatus status2 = trace1.begin("hello2");

        trace1.end(status2);
        trace1.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace1.begin("hello1");
        TraceStatus status2 = trace1.begin("hello2");

        trace1.exception(status2, new IllegalStateException());
        trace1.exception(status1, new IllegalStateException());
    }


}
