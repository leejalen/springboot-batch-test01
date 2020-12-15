package com.example.springbootbatchtest01.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.JobStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description Job的嵌套
 */
@Configuration
@EnableBatchProcessing
public class JobConfigurationDemo05 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Job job_childJob1;

    @Autowired
    private Job job_childJob2;

    @Autowired
    private JobLauncher jobLauncher;

    @Bean
    public Job parentJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return jobBuilderFactory.get("parentJob")
                .start(childJob1(jobRepository, transactionManager))
                .next(childJob2(jobRepository, transactionManager))
                .build();
    }


    private Step childJob1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new JobStepBuilder(new StepBuilder("childJob1"))
                .job(job_childJob1)
                .launcher(jobLauncher)
                .repository(jobRepository)
                .transactionManager(transactionManager)
                .build();
    }

    private Step childJob2(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new JobStepBuilder(new StepBuilder("childJob2"))
                .job(job_childJob2)
                .launcher(jobLauncher)
                .repository(jobRepository)
                .transactionManager(transactionManager)
                .build();
    }
}
