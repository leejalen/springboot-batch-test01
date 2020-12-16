package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description 输出数据到数据库
 */
@Configuration
@EnableBatchProcessing
public class JobConfigurationDemo13 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private FlatFileItemReader<User> flatFileItemReader;

    @Autowired
    private JdbcBatchItemWriter<User> itemWriter;

    @Bean
    public Job job_demo13(){
        return jobBuilderFactory.get("job_demo13")
                .start(step_demo13())
                .build();
    }

    @Bean
    public Step step_demo13(){
        return stepBuilderFactory.get("step_demo13")
                .<User, User>chunk(10)
                .reader(flatFileItemReader)
                .writer(itemWriter)
                .build();
    }
}
