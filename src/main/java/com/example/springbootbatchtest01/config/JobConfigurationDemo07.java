package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.listener.step.MyStepListenerDemo07;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description job参数parameters测试 （需在program arguments中配置信息如info=qingfeng）
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo07 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MyStepListenerDemo07 myStepListenerDemo07;

    @Bean
    public Job job_demo07(){
        return jobBuilderFactory.get("job_demo07")
                .start(Step1_demo07())
                .build();
    }

    @Bean
    public Step Step1_demo07(){
        return stepBuilderFactory.get("Step1_demo07")
                .listener(myStepListenerDemo07)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step1_demo07");
                        //测试数据
                        Map<String, JobParameter> jobParameterMap = myStepListenerDemo07.getJobParameterMap();
                        System.out.println(jobParameterMap.get("info"));
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
