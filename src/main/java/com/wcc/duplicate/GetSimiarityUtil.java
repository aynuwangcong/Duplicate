package com.wcc.duplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 余弦相似度计算工具类
 *
 */

public class
GetSimiarityUtil {

    Map<String, int[]> vectorMap = new HashMap<String, int[]>();
    int[] tempArray = null;
    /**
     * 构造器 在这里面分词
     * @param str1 文本1
     * @param str2 文本2
     */
    public GetSimiarityUtil(String str1, String str2) {

        for (String s : JieBaUtil.startParticiple(str1)) {//调用分词工具类进行分词
            if (vectorMap.containsKey(s)) {//判断分词是否存在
                vectorMap.get(s)[0]++;
            } else {
                tempArray = new int[2];
                tempArray[0] = 1;
                tempArray[1] = 0;
                vectorMap.put(s, tempArray);
            }
        }
        for (String s2 : JieBaUtil.startParticiple(str2)) {
            if (vectorMap.containsKey(s2)) {
                vectorMap.get(s2)[1]++;
            } else {
                tempArray = new int[2];
                tempArray[0] = 0;
                tempArray[1] = 1;
                vectorMap.put(s2, tempArray);
            }
        }
    }

    /**
     *  求平方和
     * @param paramMap 键值对，记录词组的数量
     * @return 返回词组平方和
     */
    private double squares(Map<String, int[]> paramMap) {
        double result1 = 0;
        double result2 = 0;
        Set<String> keySet = paramMap.keySet();
        for (String character : keySet) {
            int temp[] = paramMap.get(character);
            result1 += (temp[0] * temp[0]);
            result2 += (temp[1] * temp[1]);
        }
        return result1 * result2;
    }
    //平方相加
    private double sqrtMulti(Map<String, int[]> paramMap) {
        double result = 0;
        result = squares(paramMap);
        result = Math.sqrt(result);
        return result;
    }

    // 点乘法
    private double pointMulti(Map<String, int[]> paramMap) {
        double result = 0;
        Set<String> keySet = paramMap.keySet();
        for (String character : keySet) {
            int temp[] = paramMap.get(character);
            result += (temp[0] * temp[1]);
        }
        return result;
    }
    // 求余弦相似度
    public double sim() {
        double result = 0;
        result = pointMulti(vectorMap) / sqrtMulti(vectorMap);
        return result;
    }




}
