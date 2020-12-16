package com.example.springbootbatchtest01.config.reader;

import com.example.springbootbatchtest01.config.entity.User;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description
 */
@Configuration
public class ReaderDemo13 {

    @Bean
    public FlatFileItemReader<User> flatFileItemReader(){
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("user-data.csv"));
        //跳过第一行
        reader.setLinesToSkip(1);

        //解析数据
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(new String[]{"username", "password", "age"});
        //解析的数据映射为实体对象
        DefaultLineMapper<User> mapper = new DefaultLineMapper<>();
        mapper.setLineTokenizer(tokenizer);
        mapper.setFieldSetMapper(new FieldSetMapper<User>() {
            @Override
            public User mapFieldSet(FieldSet fieldSet) throws BindException {
                User user = new User();
                user.setUsername(fieldSet.readString("username"));
                user.setPassword(fieldSet.readString("password"));
                user.setAge(fieldSet.readString("age"));
                return user;
            }
        });
        mapper.afterPropertiesSet();
        reader.setLineMapper(mapper);
        return reader;
    }
}
