package hello.advanced.trace.strategy.code.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관하는 방식
 */
@Slf4j
@RequiredArgsConstructor
public class ContextV2 {

    public void execute(Strategy strategy) {
        long start = System.currentTimeMillis();
        strategy.call();
        long end = System.currentTimeMillis();
        long result = start - end;
        log.info("result Time {}ms", result);
    }
}
