package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallBackTemplate;
import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {
    private final TraceCallBackTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceCallBackTemplate(trace);
    }

    public void save(String itemId) throws IllegalAccessException {
        template.execute("OrderRepository.save()", () -> {
            if(itemId.equals("ex")) {
                throw new IllegalAccessException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
