package com.example.springbootbatchtest01.config.writer;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description
 */
@Component("writer")
public class WriterDemo10 implements ItemWriter<User> {
    @Override
    public void write(List<? extends User> list) throws Exception {
        for (User item : list){
            System.out.println(item.toString());
        }
        System.out.println("????????????????????");
    }
}
