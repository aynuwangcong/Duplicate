package com.wcc.duplicate;

import java.io.File;

public class DupCheckMain {

    /**
     * @return 返回结果
     */
    public double getRepetiveRate(String originalPath, String plagiarizePath) {
        Double result = null;
        File originalFile = new File(originalPath);
        File plagiarizeFile = new File(plagiarizePath);
        String oriStr = IOUtil.textToString(originalPath); //文本转为字符串
        String plagStr = IOUtil.textToString(plagiarizePath);
        if (!originalFile.exists() || !plagiarizeFile.exists()) {  //文件不存在
            return 0;
        }
        //余弦相似度计算
        GetSimiarityUtil getSimiarityUtil = new GetSimiarityUtil(oriStr, plagStr);
        System.out.println("相似度："+getSimiarityUtil.sim());
        result = getSimiarityUtil.sim();//输出结果

        IOUtil.StringToFile("D:/idea/myDemo/result.txt", originalPath + "\n" + plagiarizePath + "\n"
                + "相似度 ：" + result);
        return result;
    }


}
