package indi.xm.jy.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1668
 * @Author: albert.fang
 * @Description: 1668. 最大重复子字符串
 * @Date: 2022/11/3 12:01
 */
public class SN1668 {

    // 思路：模拟
    // 1、迭代seq字符串的每个字符位置（0 - seq.len - word.len），将每个位置尝试着作为word开头，维护一个res
    // 2、如果能匹配上，那么给这次的匹配结果一个临时变量ans存储，i + word.len
    public int maxRepeating(String sequence, String word) {
        int max = 0,res = 0;
        for (int i = 0; i <= sequence.length() - word.length(); i++) {
            boolean flag = true;
            int ans = 0,l = i, r = i + word.length() - 1;
            while ( r < sequence.length()){
                int m = l;
                for (; l <= r; l++) {
                    if (word.charAt(l-m) != sequence.charAt(l)) {
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    ans ++;
                    r += word.length();
                }else break;
            }
            max = Math.max(ans,max);
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
