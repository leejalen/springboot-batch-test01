package com.example.springbootbatchtest01.config.writer;

import com.example.springbootbatchtest01.config.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author leejalen
 * Created on 2020/12/17
 * @Description
 */
@Component
public class WriterDemo17 {

    @Bean
    public CompositeItemWriter<User> writer17() throws Exception {
        CompositeItemWriter<User> multiWriter = new CompositeItemWriter<>();
        multiWriter.setDelegates(Arrays.asList(writer_csv(), writer_xml()));
        multiWriter.afterPropertiesSet();
        System.out.println("writer17写入完成");
        return multiWriter;
    }

    /**
     * 将数据写入csv文件
     * */
    public FlatFileItemWriter<User> writer_csv() throws Exception {
        //把User对象转化为字符串输出到文件
        FlatFileItemWriter<User> writer = new FlatFileItemWriter<>();

        String filePath = newFilePath("csv");

        writer.setResource(new FileSystemResource(filePath));

        //把User对象转化为字符串
        writer.setLineAggregator(new LineAggregator<User>() {
            ObjectMapper objectMapper = new ObjectMapper();
            @Override
            public String aggregate(User user) {
                String str = null;
                try {
                    //str = objectMapper.writeValueAsString(user);
                    StringBuilder stringBuilder = new StringBuilder();
                    Integer id = user.getId();
                    String username = user.getUsername();
                    String password = user.getPassword();
                    String age = user.getAge();
                    stringBuilder = stringBuilder.append(id).append(",").append(username).append(",").
                            append(password).append(",").append(age);
                    str = stringBuilder.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return str;
            }
        });
        writer.afterPropertiesSet();
        System.out.println("17写入csv");
        return writer;
    }

    /**
     * 将数据写入xml文件
     * */
    public StaxEventItemWriter<User> writer_xml() throws Exception {
        StaxEventItemWriter<User> writer = new StaxEventItemWriter<>();
        XStreamMarshaller marshaller = new XStreamMarshaller();
        Map<String, Class> aliases = new HashMap<>();
        aliases.put("user", User.class);
        marshaller.setAliases(aliases);

        writer.setRootTagName("users");
        writer.setMarshaller(marshaller);

        String filePath = newFilePath("xml");

        writer.setResource(new FileSystemResource(filePath));
        writer.afterPropertiesSet();
        System.out.println("17写入xml");
        return writer;
    }

    public String newFilePath(String type){
        String directory = "D:\\testPackage\\";
        String fileName = UUID.randomUUID() + "." + type;
        String filePath = directory + fileName;
        return filePath;
    }
}
