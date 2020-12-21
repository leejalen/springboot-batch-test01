package com.example.springbootbatchtest01.config.processor;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leejalen
 * Created on 2020/12/21
 * @Description
 */
@Component
public class MultiProcessorDemo17 {

    @Autowired
    private ItemProcessor<User, User> processor17;

    @Autowired
    private ItemProcessor<User, User> processor171;

    @Bean
    public CompositeItemProcessor<User, User> multiProcessor17(){
        CompositeItemProcessor<User, User> processor = new CompositeItemProcessor<>();
        List<ItemProcessor<User, User>> list = new ArrayList<>();
        list.add(processor171);
        list.add(processor17);
        processor.setDelegates(list);
        return processor;
    }
}
