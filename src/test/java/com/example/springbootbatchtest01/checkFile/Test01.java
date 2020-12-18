package com.example.springbootbatchtest01.checkFile;

import java.io.*;

/**
 * @author leejalen
 * Created on 2020/12/18
 * @Description
 */
public class Test01 {

    public static void readTest() throws IOException {
        String filePath = "D:\\testPackage\\IND20050132ACOMA";
        BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(filePath));
        BufferedReader reader = new BufferedReader(new InputStreamReader(buffIn, "gbk"));
        String line = reader.readLine();
        String address = line.substring(336, 376);

        String[] add = address.split(" ");
        String add0 = add[0].trim();
        int add0Length = add0.length();
        StringBuilder spaceStr = new StringBuilder();
        for (int i = 0; i < add0Length * 2 ; i++) {
            spaceStr = spaceStr.append(" ");
        }

        line = line.replace(add[0], spaceStr.toString());
        String address1 = line.substring(391, 400);
        System.out.println(address1);

        System.out.println(add[0]);


//        byte[] bytes = line.getBytes();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        int length = 3;
//        int start = 0;
//        byte[] array = new byte[length];
//        for (int i = 391; i < 394; i++) {
//            array[start] = bytes[i];
//            start++;
//        }
//        String str = new String(array, "utf-8");
//        System.out.println(str);
//        String str = new String(String.valueOf(bytes[i]));
//        System.out.println(str);
//        stringBuilder = stringBuilder.append(bytes[i]);

    }

    public static void main(String[] args) throws IOException {
        readTest();
    }
}
