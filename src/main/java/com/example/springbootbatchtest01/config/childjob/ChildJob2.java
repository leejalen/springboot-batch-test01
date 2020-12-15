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
 * @Description 子任务2
 */
//@Configuration
public class ChildJob2 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job_childJob2(){
        return jobBuilderFactory.get("job_childJob2")
                .start(step_childJob2())
                .build();
    }

    @Bean
    public Step step_childJob2(){
        return stepBuilderFactory.get("step_childJob2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " step_childJob2");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
