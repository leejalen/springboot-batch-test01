package com.example.springbootbatchtest01.checkFile;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @author leejalen
 * Created on 2020/12/19
 * @Description 解析银联对账文件的公共工具
 */
public class PraseCommonUtil {

    BufferedInputStream buffIn = null;
    BufferedReader reader = null;

    BufferedOutputStream buffOut = null;
    BufferedWriter writer = null;

    /**
     * 解析文件的方法 List中必须包含三个值 下标0：起始位置  下标1：长度  下标2：备注（字段名）
     * @param oldFilePath 原文件地址
     * @param newFilePath 新文件地址
     * @param fieldInfoMap 要解析的文件中的字段信息的map集合
     * @param chineseIndex 如果要解析的文件中某一行的其中一个字段是中文，标明这是第几个字段；如果不存在，此形参填入任意负数
     * */
    public int parse(String oldFilePath, String newFilePath, Map<Integer, List<Object>> fieldInfoMap, Integer chineseIndex) throws IOException {

        int count = 0;
        try {
            buffIn = new BufferedInputStream(new FileInputStream(oldFilePath));
            reader = new BufferedReader(new InputStreamReader(buffIn, "GBK"));

            buffOut = new BufferedOutputStream(new FileOutputStream(newFilePath));
            writer =new BufferedWriter(new OutputStreamWriter(buffOut,"GBK"));
            //初始化文件表头
            initFile(writer, fieldInfoMap);

            String line = null;
            while ((line = reader.readLine()) != null){
                count++;
                StringBuilder newLine = new StringBuilder();
                for (int i = 0; i < fieldInfoMap.size(); i++) {
                    List<Object> fieldInfo = fieldInfoMap.get(i+1);
                    int fieldStart = (Integer) fieldInfo.get(0);
                    int fieldLength = (Integer) fieldInfo.get(1);
                    String thisField = line.substring(fieldStart, fieldStart + fieldLength).trim();

                    if (i == 0 ){
                        newLine = newLine.append("=\"").append(thisField).append("\"");
                        continue;
                    }
                    if (i == (chineseIndex - 1)){
                        String chineseField = line.substring(fieldStart, fieldStart + fieldLength);
                        String realChineseField = chineseField.split(" ")[0].trim();
                        int realField41Length = realChineseField.length();

                        StringBuilder spaceStr = new StringBuilder();
                        for (int j = 0; j < realField41Length * 2 ; j++) {
                            spaceStr = spaceStr.append(" ");
                        }
                        line = line.replace(realChineseField, spaceStr.toString());
                        thisField = realChineseField;
                    }
                    newLine = newLine.append(",").append("=\"").append(thisField).append("\"");
                }
                writer.write(newLine.toString());
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void closeStream() throws IOException {
        //关闭流和读写

        if (reader != null){
            reader.close();
        }
        if (writer != null){
            writer.close();
        }
        if (buffIn != null){
            buffIn.close();
        }
        if (buffOut != null){
            buffOut.close();
        }
    }

    /**
     * 初始化表头信息
     * */
    public static void initFile(BufferedWriter writer, Map<Integer, List<Object>> fieldInfoMap) throws IOException {
        //序号
        StringBuilder seqStr = new StringBuilder();
        //字段名
        StringBuilder fieldName = new StringBuilder();
        for (int i = 0; i < fieldInfoMap.size(); i++) {
            List<Object> fieldInfo = fieldInfoMap.get(i+1);
            if ( i == 0){
                seqStr = seqStr.append("序号").append(i + 1);
                fieldName = fieldName.append(fieldInfo.get(2));
            }else {
                seqStr = seqStr.append(",").append("序号").append(i + 1);
                fieldName = fieldName.append(",").append(fieldInfo.get(2));
            }
        }
        writer.write(seqStr.toString());
        writer.newLine();
        writer.write(fieldName.toString());
        writer.newLine();
    }
}
