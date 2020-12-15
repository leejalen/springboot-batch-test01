package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.decider.DeciderDemo04;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
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
 * @Description 决策器指定复杂条件 JobExecutionDecider
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo04 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job_demo04(){
        return jobBuilderFactory.get("job_demo04")
                .start(Step1_demo04())
                .next(decider_demo04())
                .from(decider_demo04()).on("even").to(Step2_demo04())
                .from(decider_demo04()).on("odd").to(Step3_demo04())
                .from(Step3_demo04()).on("*").to(decider_demo04())
                .end()
                .build();
    }

    @Bean
    public JobExecutionDecider decider_demo04(){
        return new DeciderDemo04();
    }

    @Bean
    public Step Step1_demo04(){
        return stepBuilderFactory.get("Step1_demo04")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step1_demo04");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step2_demo04(){
        return stepBuilderFactory.get("Step2_demo04")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step2_demo04");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step3_demo04(){
        return stepBuilderFactory.get("Step3_demo04")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step3_demo04");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step4_demo04(){
        return stepBuilderFactory.get("Step4_demo04")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step4_demo04");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
