package com.example.springbootbatchtest01.config.listener.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description 任务监听器
 */
@Component
public class MyJobListener implements JobExecutionListener{
    @Override
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println(jobName + "开始启动");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println(jobName + "执行完成");
    }
}
