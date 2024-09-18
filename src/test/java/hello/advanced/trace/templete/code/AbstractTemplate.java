package hello.advanced.trace.templete.code;

import lombok.extern.slf4j.Slf4j;

//템플릿 메서드 패턴
@Slf4j
public abstract class AbstractTemplate {
    public void execute() {
        long start = System.currentTimeMillis();
        //비지니스 로직 실행
        call();
        long end = System.currentTimeMillis();
        long result = start - end;
        log.info("{}ms", result);
    }
    protected abstract void call();

}
