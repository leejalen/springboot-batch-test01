package com.example.springbootbatchtest01.config.processor;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author leejalen
 * Created on 2020/12/21
 * @Description
 */
@Component("processor17")
public class ProcessorDemo17 implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setUsername(user.getUsername() + ":processor17");
        user1.setPassword(user.getPassword() + ":processor17");
        user1.setAge(user.getAge() + ":processor17");
        return user1;
    }
}
