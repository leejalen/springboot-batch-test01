package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.listener.job.MyJobListener;
import com.example.springbootbatchtest01.config.listener.job.MyJobListenerAnnotation;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description
 */
@Configuration
@EnableBatchProcessing
public class JobConfigurationDemo06 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MyJobListenerAnnotation myJobListenerAnnotation;

    @Bean
    public Job job_demo06(){
        return jobBuilderFactory.get("job01_demo06")
                .start(Step1_demo06())
                .listener(new MyJobListener())
                .build();
    }

    @Bean
    public Step Step1_demo06(){
        return stepBuilderFactory.get("Step01_demo06")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + Thread.currentThread().getName() + " Step01_demo06");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
