package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import com.example.springbootbatchtest01.config.reader.ReaderDemo16;
import com.example.springbootbatchtest01.config.writer.WriterDemo16;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author leejalen
 * Created on 2020/12/17
 * @Description
 */
@Configuration
@EnableBatchProcessing
public class JobConfigurationDemo16 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ReaderDemo16 readerDemo16;

    @Autowired
    private WriterDemo16 writerDemo16;

    @Bean
    public Job job_demo16() throws Exception {
        return jobBuilderFactory.get("job24_demo16")
                .start(step_demo16())
                .build();
    }

    @Bean
    public Step step_demo16() throws Exception {
        return stepBuilderFactory.get("step24_demo16")
                .<User, User>chunk(10)
                .reader(readerDemo16.reader16())
                .writer(writerDemo16.writer16())
                .build();
    }
}
