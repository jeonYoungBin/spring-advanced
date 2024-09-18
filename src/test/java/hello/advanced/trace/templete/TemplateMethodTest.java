package hello.advanced.trace.templete;

import hello.advanced.trace.templete.code.AbstractTemplate;
import hello.advanced.trace.templete.code.SubClassLogic1;
import hello.advanced.trace.templete.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {
    @Test
    void templeteMethod0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long start = System.currentTimeMillis();
        //비지니스 로직 실행
        log.info("비지니스1 로직 실행");
        //비지니스 로직 종
        long end = System.currentTimeMillis();
        long result = start - end;
        log.info("{}ms", result);
    }

    private void logic2() {
        long start = System.currentTimeMillis();
        //비지니스 로직 실행
        log.info("비지니스2 로직 실행");
        //비지니스 로직 종
        long end = System.currentTimeMillis();
        long result = start - end;
        log.info("{}ms", result);
    }

    /**
     * 템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodPatternV1() {
        AbstractTemplate template = new SubClassLogic1();
        template.execute();

        AbstractTemplate template1 = new SubClassLogic2();
        template1.execute();
    }

    @Test
    void templateMethodPatternV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 1 실행");
            }
        };

        log.info("temp1Class{}", template1.getClass());
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };

        log.info("temp2Class{}", template2.getClass());
        template2.execute();
    }


}