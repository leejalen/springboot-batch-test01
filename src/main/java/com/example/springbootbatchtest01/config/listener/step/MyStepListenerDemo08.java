package com.example.springbootbatchtest01.config.listener.step;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description
 */
@Component
public class MyStepListenerDemo08 implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("块监听启动");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("块监听完成");
        return ExitStatus.COMPLETED;
    }


}
