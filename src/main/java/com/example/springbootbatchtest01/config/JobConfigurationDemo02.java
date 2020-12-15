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

import java.util.Date;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description Flow的运用，Flow中可以包括多个步骤
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo02 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job job_demo02(){
        return jobBuilderFactory.get("job_demo02")
                .start(flow_demo02())
                .next(Step3_demo02())
                .end()
                .build();
    }

    @Bean
    public Flow flow_demo02(){
        return new FlowBuilder<Flow>("flow_demo02")
                .start(Step1_demo02())
                .next(Step2_demo02())
                .build();
    }


    @Bean
    public Step Step1_demo02(){
        return stepBuilderFactory.get("Step1_demo02")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + " Step1_demo02");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step2_demo02(){
        return stepBuilderFactory.get("Step2_demo02")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + " Step2_demo02");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step3_demo02(){
        return stepBuilderFactory.get("Step3_demo02")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + " Step3_demo02");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
