package com.example.springbootbatchtest01.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description 指定一个任务的每个步骤的执行顺序 .start() .next() .end() .from().on()
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo01 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * 可用条件语句
     * from(step1()).on("COMPLETED").to(Step2()) 当步骤1完成时执行步骤2
     * from(step1()).end() 当步骤1完成时流程结束
     * stopAndRestart() 从当前步骤重启
     * 表示
     * */
    @Bean
    public Job job_demo01(){
        return jobBuilderFactory.get("job_demo01")
                .start(Step1_demo01())
                .next(Step2_demo01())
                .next(Step3_demo01())
                .build();
    }

    @Bean
    public Step Step1_demo01(){
        return stepBuilderFactory.get("Step1_demo01")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + " Step1_demo01");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step2_demo01(){
        return stepBuilderFactory.get("Step2_demo01")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + " Step2_demo01");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step Step3_demo01(){
        return stepBuilderFactory.get("Step3_demo01")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(new Date() + " Step3_demo01");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
