package com.example.springbootbatchtest01.config.writer;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author leejalen
 * Created on 2020/12/17
 * @Description
 */
@Component
public class WriterDemo15 {

    public StaxEventItemWriter<User> writer15() throws Exception {
        StaxEventItemWriter<User> writer = new StaxEventItemWriter<>();
        XStreamMarshaller marshaller = new XStreamMarshaller();
        Map<String, Class> aliases = new HashMap<>();
        aliases.put("user", User.class);
        marshaller.setAliases(aliases);

        writer.setRootTagName("users");
        writer.setMarshaller(marshaller);

        String filePath = newFilePath();
        writer.setResource(new FileSystemResource(filePath));
        writer.afterPropertiesSet();
        System.out.println("writer_demo15写入完成");
        return writer;
    }

    public String newFilePath(){
        String directory = "D:\\testPackage\\";
        String fileName = UUID.randomUUID() + ".xml";
        String filePath = directory + fileName;
        return filePath;
    }
}
