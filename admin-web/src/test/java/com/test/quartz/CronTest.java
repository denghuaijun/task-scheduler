package com.test.quartz;

import com.ct.admin.AdminWebApplication;
import com.ct.admin.model.TaskDTO;
import com.ct.admin.service.TaskService;
import com.ct.admin.service.TaskrunnerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminWebApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootApplication
@Slf4j
public class CronTest {


    @Resource
    private TaskrunnerService taskrunService;

    @Resource
    private TaskService taskService;


    @Before
    public void before() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10L);
    }

    /**
     * 仅启动
     * @throws InterruptedException
     */
    @Test
    public void testRun() throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

    /**
     * 添加任务
     * @throws InterruptedException
     */
    @Test
    public void testAddTask() throws InterruptedException {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskName("test1");
        taskDTO.setTaskCron("*/5 * * * * ? *");
        taskDTO.setTaskRunnerId(1L);
        taskService.taskAdd(taskDTO);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }


    /**
     * 删除任务
     * @throws InterruptedException
     */
    @Test
    public void testDeleteTask() throws InterruptedException {
        taskService.taskDelete(52l);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

}
