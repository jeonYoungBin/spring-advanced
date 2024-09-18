package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallBackTemplate;
import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceCallBackTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceCallBackTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) throws IllegalAccessException {
        return template.execute("OrderController.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }

}
