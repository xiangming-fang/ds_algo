package indi.xm.ds_algo.leetcode.sn.SN0600;

import java.util.Arrays;

/**
 * 字符串中的单词数
 */
public class SN0434 {
    // 打卡
    public int countSegments(String s) {
        return (int)Arrays.stream(s.split(" ")).filter(v -> !v.equals("")).count();
    }
}
