package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0005
 * @Author: albert.fang
 * @Description: 最长回文子串
 * @Date: 2021/8/26 18:52
 */
public class SN0005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        // 初始化成1，输入一个非回文字符串，也要输出一个，默认首位
        int maxLen = 1;
        int startIndex = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[j] != chars[i]){
                    dp[i][j] = false;
                }
                else {
                    // j - i < 3 是由
                    // j - 1 - (i + 1) + 1 < 2 演变得来的
                    // 为啥要满足j - 1 - (i + 1) + 1 < 2这个式子呢?
                    // 是因为判断子串的长度是大于2
                    if (j - i < 3){
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    startIndex = i;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("babab"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }

}
