package com.example.springbootbatchtest01.config.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description 自定义JobExecutionDecider决策器
 */
public class DeciderDemo04 implements JobExecutionDecider {

    private int count;

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        count++;
        if (count % 2 == 0){
            return new FlowExecutionStatus("even");
        } else {
            return new FlowExecutionStatus("odd");
        }
    }
}
