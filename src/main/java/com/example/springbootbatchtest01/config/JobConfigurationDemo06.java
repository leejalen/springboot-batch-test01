package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.listener.chunk.MyChunkListener;
import com.example.springbootbatchtest01.config.listener.job.MyJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description job的监听、step的监听、chunk的监听
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo06 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MyJobListener myJobListener;

    @Bean
    public Job job_demo06(){
        return jobBuilderFactory.get("job02_demo06")
                .listener(myJobListener)
                .start(Step1_demo06())
                .build();
    }

    @Bean
    public Step Step1_demo06(){
        return stepBuilderFactory.get("Step02_demo06")
                .<String, String>chunk(2)
                .faultTolerant()
                .listener(new MyChunkListener())
                .reader(reader_demo06())
                .writer(writer_demo06())
                .build();
    }

    @Bean
    public ItemReader<String> reader_demo06() {
        return new ListItemReader<>(Arrays.asList("java", "spring", "mybatis"));
    }

    @Bean
    public ItemWriter<String> writer_demo06(){
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> items) throws Exception {
                for(String item : items){
                    System.out.println(item);
                }
            }
        };
    }
}
