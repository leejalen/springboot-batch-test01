package com.example.springbootbatchtest01.config.reader;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/17
 * @Description
 */
@Component
public class ReaderDemo16 {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcPagingItemReader<User> reader16(){
        JdbcPagingItemReader<User> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setFetchSize(10);
        //读取的数据转化为对象
        reader.setRowMapper(new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setAge(resultSet.getString(4));
                return user;
            }
        });
        //指定sql语句
        MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
        queryProvider.setSelectClause("id, username, password, age");
        queryProvider.setFromClause("from batch_test_user");

        //指定排序
        Map<String, Order> sort = new HashMap<>();
        sort.put("id", Order.ASCENDING);
        queryProvider.setSortKeys(sort);

        reader.setQueryProvider(queryProvider);

        System.out.println("reader_demo16读取完成");
        return reader;
    }
}
