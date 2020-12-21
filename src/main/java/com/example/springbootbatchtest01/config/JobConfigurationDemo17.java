package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2020/12/21
 * @Description ItemProcessor处理
 */
@Configuration
public class JobConfigurationDemo17 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<User> reader17;

    @Autowired
    private ItemProcessor<User, User> processor17;

    @Autowired
    private ItemProcessor<User, User> multiProcessor17;

    @Autowired
    private ItemWriter<User> writer17;

    @Bean
    public Job job_demo17() throws Exception {
        return jobBuilderFactory.get("job18_demo17")
                .start(step_demo17())
                .build();
    }

    @Bean
    public Step step_demo17() throws Exception {
        return stepBuilderFactory.get("step18_demo17")
                .<User, User>chunk(10)
                .reader(reader17)
                .processor(multiProcessor17)
                .writer(writer17)
                .build();
    }
}
