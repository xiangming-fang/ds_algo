package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0003_2
 * @Author: albert.fang
 * @Description: 最长连续子串
 * @Date: 2022/10/28 14:53
 */
public class SN0003_2 {

    public int lengthOfLongestSubstring01(String s) {
        int res = 0;
        int[] hash = new int[256];
        for (int i = 0,j = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
            while (j < i && hash[s.charAt(i)] > 1) hash[s.charAt(j++)]--;
            res = Math.max(res,i - j + 1);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring01(" 232222"));
    }
}
