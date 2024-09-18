package hello.advanced.trace.strategy.code.strategy;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callBackV1() {
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(() -> log.info("비지니스 로직 1"));
        template.execute(() -> log.info("비지니스 로직 2"));
    }
}
