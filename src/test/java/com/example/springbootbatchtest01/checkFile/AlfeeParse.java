package com.example.springbootbatchtest01.checkFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/19
 * @Description
 */
public class AlfeeParse {

    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();

        String dirPath = "D:\\testPackage\\oldALFEE\\";
        File file = new File(dirPath);
        String[] fileList = file.list();

        Map<Integer, List<Object>> fieldInfoMap = AlfeeEnum.getAlfeeMap();
        Integer chineseIndex = -1;
        int count = 0;


        for (int i = 0; i < fileList.length; i++) {
            PraseCommonUtil praseCommonUtil = new PraseCommonUtil();
            String oldFileName = fileList[i];
            String oldFilePath = dirPath + oldFileName;
            String newFilePath = "D:\\testPackage\\newALFEE\\" + oldFileName + ".csv";
            int parseNum = praseCommonUtil.parse(oldFilePath, newFilePath, fieldInfoMap, chineseIndex);
            count = count +parseNum;
            praseCommonUtil.closeStream();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("解析完成"+count +" 耗时:" + (endTime - startTime));
    }
}
