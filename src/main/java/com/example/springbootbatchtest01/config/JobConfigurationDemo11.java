package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import com.example.springbootbatchtest01.config.reader.ReaderDemo11;
import com.example.springbootbatchtest01.config.writer.WriterDemo11;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description StaxEventItemReader从xml文件中读取数据
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo11 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ReaderDemo11 readerDemo11;

    @Autowired
    private WriterDemo11 writerDemo11;

    @Bean
    public Job job_demo11(){
        return jobBuilderFactory.get("job_demo11")
                .start(step_demo11())
                .build();
    }

    @Bean
    public Step step_demo11(){
        return stepBuilderFactory.get("step_demo11")
                .<User, User>chunk(2)
                .reader(readerDemo11.reader())
                .writer(writerDemo11)
                .build();
    }
}
