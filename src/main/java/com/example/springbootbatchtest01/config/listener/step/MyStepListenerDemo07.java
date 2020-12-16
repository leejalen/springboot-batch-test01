package com.example.springbootbatchtest01.config.listener.step;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description
 */
@Component
public class MyStepListenerDemo07 implements StepExecutionListener {

    private Map<String, JobParameter> jobParameterMap;

    public Map<String, JobParameter> getJobParameterMap() {
        return jobParameterMap;
    }

    public void setJobParameterMap(Map<String, JobParameter> jobParameterMap) {
        this.jobParameterMap = jobParameterMap;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("监听启动");
        Map<String, JobParameter> params = stepExecution.getJobParameters().getParameters();
        setJobParameterMap(params);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("监听完成");
        return ExitStatus.COMPLETED;
    }


}
