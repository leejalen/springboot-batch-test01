package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2020/12/17
 * @Description 从数据库输出文件到普通文件
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo14 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

//    @Autowired
//    @Qualifier("reader_demo14")
//    private ItemReader<User> reader;
//
//    @Autowired
//    @Qualifier("writer_demo14")
//    private ItemWriter<User> writer;

//    @Bean
//    public Job job_demo14(){
//        return jobBuilderFactory.get("job02_demo14")
//                .start(step_demo14())
//                .build();
//    }
//
//    @Bean
//    public Step step_demo14(){
//        return stepBuilderFactory.get("step02_demo14")
//                .<User, User>chunk(10)
//                .reader(reader)
//                .writer(writer)
//                .build();
//    }

}
