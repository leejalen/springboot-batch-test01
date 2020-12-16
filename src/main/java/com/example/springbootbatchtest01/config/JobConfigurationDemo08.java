package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.listener.step.MyStepListenerDemo08;
import com.example.springbootbatchtest01.config.reader.ReaderDemo08;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description ItemReader测试
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo08 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job_demo08(){
        return jobBuilderFactory.get("job04_demo08")
                .start(step_demo08())
                .build();
    }

    @Bean
    public Step step_demo08(){
        List<String> listTemp = new ArrayList<>();
        listTemp.add("cat");
        listTemp.add("dog");
        listTemp.add("pig");
        listTemp.add("duck");

        return stepBuilderFactory.get("step04_demo08")
                .<String, String>chunk(2)
                .reader(new ReaderDemo08(listTemp))
                .writer(list -> {
                    for (String item : list){
                        System.out.println(item);
                    }
                    System.out.println("====================");
                    Thread.sleep(2000);
                })
                .build();
    }

}
