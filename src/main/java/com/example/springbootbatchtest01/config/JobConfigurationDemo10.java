package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import com.example.springbootbatchtest01.config.reader.ReaderDemo10;
import com.example.springbootbatchtest01.config.writer.WriterDemo10;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description FlatFileItemReader从普通文件读取数据
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo10 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private FlatFileItemReader<? extends User> reader;

    @Autowired
    private ItemWriter<User> writerDemo09;

//    @Bean
//    public Job job_demo10(){
//        return jobBuilderFactory.get("job03_demo10")
//                .start(step_demo10())
//                .build();
//    }
//
//    @Bean
//    public Step step_demo10(){
//        return stepBuilderFactory.get("step03_demo10")
//                .<User, User>chunk(10)
//                .reader(reader)
//                .writer(writerDemo09)
//                .build();
//    }
}
