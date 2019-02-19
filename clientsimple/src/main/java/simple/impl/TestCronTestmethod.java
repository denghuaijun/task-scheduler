package simple.impl;

import com.ct.core.annotation.Runner;
import com.ct.core.client.RunnerInvokerDef;
import com.ct.core.model.ReturnDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试调度类
 */
@Runner(appname = "methodtest")
public class TestCronTestmethod implements RunnerInvokerDef {

    @Autowired
    private TestService testService;

    @Override
    public ReturnDTO<String> run() {
        System.out.println("methodtest");
        return null;
    }
}
