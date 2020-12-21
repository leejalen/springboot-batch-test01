package com.example.springbootbatchtest01.config.processor;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author leejalen
 * Created on 2020/12/21
 * @Description
 */
@Component("processor171")
public class ProcessorDemo171 implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        if ((user.getId() % 2) == 0){
            return user;
        }else {
            return null;
        }
    }
}
