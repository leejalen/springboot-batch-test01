package com.example.springbootbatchtest01.config.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author leejalen
 * Created on 2020/12/16
 * @Description
 */
public class ReaderDemo08 implements ItemReader<String> {

    private Iterator<String> iterator;

    public ReaderDemo08(List<String> list) {
        this.iterator = list.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (iterator.hasNext()){
            return iterator.next();
        } else {
            return null;
        }
    }
}
