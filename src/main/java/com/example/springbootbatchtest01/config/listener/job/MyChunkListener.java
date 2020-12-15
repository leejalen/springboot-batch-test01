package com.example.springbootbatchtest01.config.listener.job;

import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.scope.context.ChunkContext;

/**
 * @author leejalen
 * Created on 2020/12/15
 * @Description
 */
public class MyChunkListener {

    @BeforeChunk
    public void beforeChunk(ChunkContext chunkContext){
        System.out.println(chunkContext.getStepContext().getStepName() + "开始启动");
    }

    @AfterChunk
    public void afterChunk(ChunkContext chunkContext){
        System.out.println(chunkContext.getStepContext().getStepName() + "执行完成");
    }
}
