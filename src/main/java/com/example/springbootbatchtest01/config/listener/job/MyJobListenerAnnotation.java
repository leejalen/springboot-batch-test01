package com.example.springbootbatchtest01.config.listener.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description
 */
@Component
public class MyJobListenerAnnotation{

    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println(jobName + "开始启动");
    }

    @AfterJob
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println(jobName + "执行完成");
    }

}
