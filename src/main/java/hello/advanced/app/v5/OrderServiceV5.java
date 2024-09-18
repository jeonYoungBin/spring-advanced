package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallBackTemplate;
import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceCallBackTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.template = new TraceCallBackTemplate(logTrace);
    }

    public void orderItem(String itemId) throws IllegalAccessException {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
