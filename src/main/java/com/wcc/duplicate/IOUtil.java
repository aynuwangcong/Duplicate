package com.wcc.duplicate;

import java.io.*;

public class IOUtil {

    /**
     *
     * @param path 文件路径
     * @return 返回字符串
     */
    //文本转换成字符串
    public static String textToString(String path){
        if(path==null||"".equals(path)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(new FileInputStream(file), "utf-8");
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {     //逐行读取
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }


        }
        return sb.toString();
    }

    /**
     * 输出文件,输出结果
     * @param outputFilePath 输出文件的路径
     * @param result 字符串形式传入结果
     */
    //字符串转换成文本
    public static void StringToFile(String outputFilePath, String result){
        //创建输出路径的文件
        File outputFile = new File(outputFilePath);
        try (FileWriter fr = new FileWriter(outputFile)) {
            char[] cs = result.toCharArray();
            fr.write(cs);
            fr.close();
            System.out.println("结果写入 " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
