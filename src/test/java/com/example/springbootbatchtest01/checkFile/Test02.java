package com.example.springbootbatchtest01.checkFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leejalen
 * Created on 2020/12/18
 * @Description
 */
public class Test02 {

    public static void main(String[] args) {
        //String str = "（特约）湖南移动（话费业务） ";
        String str = "（特约）湖南移动（话费业务    ";
        byte[] bytes = str.getBytes();
        //System.out.println(bytes.length);

//        List<Object> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(list.get(0));
        System.out.println(AcomaEnum.getAcomaMap());
    }
}
