package com.example.springbootbatchtest01.config;

import com.example.springbootbatchtest01.config.entity.User;
import com.example.springbootbatchtest01.config.writer.WriterDemo09;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description 利用ItemReader从数据库读取数据
 */
//@Configuration
//@EnableBatchProcessing
public class JobConfigurationDemo09 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private WriterDemo09 writer;

    @Bean
    public Job job_demo09(){
        return jobBuilderFactory.get("job01_demo09")
                .start(step_demo09())
                .build();
    }

    @Bean
    public Step step_demo09(){
        return stepBuilderFactory.get("step01_demo09")
                .<User, User>chunk(2)
                .reader(reader_demo09())
                .writer(writer)
                .build();
    }

    @Bean
    public JdbcPagingItemReader<User> reader_demo09(){
        JdbcPagingItemReader<User> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setFetchSize(2);
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
        return reader;
    }
}
