package com.example.springbootbatchtest01.config.reader;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description 从指定xml文件读取数据
 */
@Component
public class ReaderDemo11 {

    public StaxEventItemReader<User> reader(){
        StaxEventItemReader<User> reader = new StaxEventItemReader<>();
        reader.setResource(new ClassPathResource("user-data.xml"));

        //指定需处理的根标签
        reader.setFragmentRootElementName("customer");
        //xml转化为对象
        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        Map<String, Class> map = new HashMap<>();
        map.put("customer", User.class);
        xStreamMarshaller.setAliases(map);

        reader.setUnmarshaller(xStreamMarshaller);
        System.out.println("ReaderDemo11读取完成");
        return reader;
    }
}
