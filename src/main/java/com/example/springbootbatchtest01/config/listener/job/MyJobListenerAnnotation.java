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
 * @Description TODO 此注解方式的监听没试验成功
 */
@Component
public class MyJobListenerAnnotation {

    @BeforeJob
    public void before(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println(jobName + "开始启动///////////");
    }

    @AfterJob
    public void after(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        System.out.println(jobName + "执行完成");
    }
}
