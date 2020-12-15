package com.example.springbootbatchtest01.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.Date;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description split实现并发执行 .split().add()
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo03 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job_demo03(){
        return jobBuilderFactory.get("job_demo03")
                .start(flow01_demo03())
                .split(new SimpleAsyncTaskExecutor())
                .add(flow02_demo03())
                .end()
                .build();
    }

    @Bean
    public Flow flow01_demo03(){
        return new FlowBuilder<Flow>("flow01_demo03")
                .start(Step1_demo03())
                .next(Step2_demo03())
                .build();
    }

    @Bean
    public Flow flow02_demo03(){
        return new FlowBuilder<Flow>("flow02_demo03")
                .start(Step3_demo03())
                .next(Step4_demo03())
                .build();
    }

    @Bean
    public Step Step1_demo03(){
        return stepBuilderFactory.get("Step1_demo03")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step1_demo03");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step2_demo03(){
        return stepBuilderFactory.get("Step2_demo03")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step2_demo03");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step3_demo03(){
        return stepBuilderFactory.get("Step3_demo03")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step3_demo03");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step4_demo03(){
        return stepBuilderFactory.get("Step4_demo03")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step4_demo03");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
