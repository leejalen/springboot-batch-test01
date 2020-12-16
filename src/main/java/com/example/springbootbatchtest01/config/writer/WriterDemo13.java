package com.example.springbootbatchtest01.config.writer;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description
 */
@Configuration
public class WriterDemo13 {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcBatchItemWriter<User> itemWriter(){
        JdbcBatchItemWriter<User> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("insert into batch_test_user(id, username, password, age)" +
                "values(:id, :username, :password, :age)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        System.out.println("----------------------------");
        return itemWriter;
    }
}
