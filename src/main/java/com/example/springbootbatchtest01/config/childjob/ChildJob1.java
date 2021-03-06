package com.example.springbootbatchtest01.config.childjob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description 子任务1
 */
//@Configuration
public class ChildJob1 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job_childJob1(){
        return jobBuilderFactory.get("job_childJob1")
                .start(step_childJob1())
                .build();
    }

    @Bean
    public Step step_childJob1(){
        return stepBuilderFactory.get("step_childJob1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " step_childJob1");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
