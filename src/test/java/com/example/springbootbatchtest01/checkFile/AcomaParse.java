package com.example.springbootbatchtest01.checkFile;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author leejalen
 * Created on 2020/12/18
 * @Description
 */
public class AcomaParse {

    public static void main(String[] args) {
        String dirPath = "D:\\testPackage\\oldCsv\\";
        File file = new File(dirPath);
        String[] fileList = file.list();
        for (int i = 0; i < fileList.length; i++) {
            String oldFileName = fileList[i];
            String oldFilePath = dirPath + oldFileName;
            String newFilePath = "D:\\testPackage\\newCsv\\" + oldFileName + ".csv";
            parse(oldFilePath, newFilePath);
        }
        //parse();
        System.out.println("解析完成");
    }

    public static void parse(String oldFilePath, String newFilePath){
        String filePath = oldFilePath;
        Map<Integer, List<Integer>> map = AcomaEnum.getAcomaMap();
        try {
            BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(filePath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(buffIn, "gbk"));

            //String newFilePath = newFilePath;

            BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(newFilePath));
            BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(buffOut));
            //初始化文件表头
            initFile(writer);

            String line = null;
            while ((line = reader.readLine()) != null){

                StringBuilder newLine = new StringBuilder();
                for (int i = 0; i < map.size(); i++) {
                    List<Integer> fieldInfo = map.get(i+1);
                    int fieldStart = fieldInfo.get(0);
                    int fieldLength = fieldInfo.get(1);
                    String thisField = line.substring(fieldStart, fieldStart + fieldLength).trim();

                    if (i == 0 ){
                        newLine = newLine.append("=\"").append(thisField).append("\"");
                        //newLine = newLine.append(thisField);
                        continue;
                    }
                    if (i == 40){
                        String field40 = line.substring(fieldStart, fieldStart + fieldLength);
                        String realField40 = field40.split(" ")[0].trim();
                        int realField41Length = realField40.length();

                        StringBuilder spaceStr = new StringBuilder();
                        for (int j = 0; j < realField41Length * 2 ; j++) {
                            spaceStr = spaceStr.append(" ");
                        }
                        line = line.replace(realField40, spaceStr.toString());
                        thisField = realField40;
                    }
                    newLine = newLine.append(",").append("=\"").append(thisField).append("\"");
                    //newLine = newLine.append(",").append(thisField);
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
    }

    public static String createFilePath(){
        String directory = "D:\\testPackage\\";
        String fileName = UUID.randomUUID() + ".csv";
        String filePath = directory + fileName;
        return filePath;
    }

    public static void initFile(BufferedWriter writer) throws IOException {
        Map<Integer, String> map = AcomaEnum.getRemarkMap();
        //序号
        StringBuilder seqStr = new StringBuilder();
        //字段名
        StringBuilder fieldName = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            if ( i == 0){
                seqStr = seqStr.append("序号").append(i + 1);
                fieldName = fieldName.append(map.get(i + 1));
            }else {
                seqStr = seqStr.append(",").append("序号").append(i + 1);
                fieldName = fieldName.append(",").append(map.get(i + 1));
            }
        }
        writer.write(seqStr.toString());
        writer.newLine();
        writer.write(fieldName.toString());
        writer.newLine();
    }
}
