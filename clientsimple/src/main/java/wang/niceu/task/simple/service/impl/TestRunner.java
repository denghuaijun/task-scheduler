package wang.niceu.task.simple.service.impl;

import com.ct.core.annotation.Runner;
import com.ct.core.client.RunnerInvokerDef;
import com.ct.core.model.ReturnDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Runner(appname = "testrunner")
public class TestRunner implements RunnerInvokerDef {
    private static long count = 0;

    @Override
    public ReturnDTO<String> run() {
        log.info("测试中:{}", (count++));
        return null;
    }
}
