package com.wcc.duplicate;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.List;

/**
 * 结巴分词工具类
 */

public class JieBaUtil {

    /**
     * 开始调用结巴分词
     * @param text1 文本1
     */
    public static List<String> startParticiple(String text1){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> s = segmenter.sentenceProcess(text1);
        System.out.println("分词结果"+s);
        return s;

      }
    }




