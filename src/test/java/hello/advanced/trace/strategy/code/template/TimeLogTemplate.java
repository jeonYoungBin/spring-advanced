package hello.advanced.trace.strategy.code.template;

import hello.advanced.trace.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long start = System.currentTimeMillis();
        callback.call();
        long end = System.currentTimeMillis();
        long result = start - end;
        log.info("result Time {}ms", result);
    }
}
