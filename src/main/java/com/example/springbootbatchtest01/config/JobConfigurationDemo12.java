package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import com.example.springbootbatchtest01.config.reader.ReaderDemo12;
import com.example.springbootbatchtest01.config.writer.WriterDemo12;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description 从多个文件中读取数据
 */
@Configuration
@EnableBatchProcessing
public class JobConfigurationDemo12 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ReaderDemo12 readerDemo12;

    @Autowired
    private WriterDemo12 writerDemo12;

    @Value("classpath:/csv/*.csv")
    private Resource[] resources;

    @Bean
    public Job job_demo12(){
        return jobBuilderFactory.get("job01_demo12")
                .start(step_demo12())
                .build();
    }

    @Bean
    public Step step_demo12(){
        return stepBuilderFactory.get("step01_demo12")
                .<User, User>chunk(10)
                .reader(multiReader())
                .writer(writerDemo12)
                .build();
    }

    @Bean
    public MultiResourceItemReader<User> multiReader(){
        MultiResourceItemReader<User> multiReader = new MultiResourceItemReader<>();
        multiReader.setDelegate(readerDemo12.reader());
        multiReader.setResources(resources);
        return multiReader;
    }
}
