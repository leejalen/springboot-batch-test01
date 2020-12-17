package com.example.springbootbatchtest01.config.writer;

import com.example.springbootbatchtest01.config.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;

/**
 * @author leejalen
 * Created on 2020/12/17
 * @Description
 */
@Component
public class WriterDemo14 {

    public FlatFileItemWriter<User> writer14() throws Exception {
        //把User对象转化为字符串输出到文件
        FlatFileItemWriter<User> writer = new FlatFileItemWriter<>();

        String filePath = newFilePath();
        File file = new File(filePath);
        file.createNewFile();

        writer.setResource(new FileSystemResource(filePath));

        //把User对象转化为字符串
        writer.setLineAggregator(new LineAggregator<User>() {
            ObjectMapper objectMapper = new ObjectMapper();
            @Override
            public String aggregate(User user) {
                String str = null;
                try {
                    str = objectMapper.writeValueAsString(user);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return str;
            }
        });
        writer.afterPropertiesSet();
        System.out.println("writer_demo14写入完成");
        return writer;
    }

    public String newFilePath(){
        String directory = "D:\\testPackage\\";
        String fileName = UUID.randomUUID() + ".csv";
        String filePath = directory + fileName;
        return filePath;
    }
}
