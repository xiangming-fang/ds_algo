package indi.xm.ds_algo.leetcode.sn.SN1500;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1456
 * @Author: albert.fang
 * @Description: 定长子串中元音的最大数目
 * @Date: 2021/9/3 17:44
 */
public class SN1456 {
    // 暴力，超出时间限制
    public int maxVowels01(String s, int k) {
        int max = 0;
        TreeSet<Character> set = new TreeSet<Character>(){{ add('a');add('e');add('i');add('o');add('u');}};
        for (int i = 0; i + k - 1 < s.length(); i++) {
            int count = 0;
            int end = i + k - 1;
            for (int j = i; j <= end ; j++) {
                if (set.contains(s.charAt(j))){
                    count ++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }

    // 滑动窗口
    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        for (int j = 0; j <= k - 1 ; j++) {
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' ||s.charAt(j) == 'i' ||s.charAt(j) == 'o' ||s.charAt(j) == 'u'){
                count ++;
            }
            max = Math.max(max,count);
        }
        for (int i = 1; i + k - 1 < s.length(); i++) {
            if (s.charAt(i-1) == 'a' || s.charAt(i-1) == 'e' ||s.charAt(i-1) == 'i' ||s.charAt(i-1) == 'o' ||s.charAt(i-1) == 'u'){
                count --;
            }
            int end = i + k - 1;
            if (s.charAt(end) == 'a' || s.charAt(end) == 'e' ||s.charAt(end) == 'i' ||s.charAt(end) == 'o' ||s.charAt(end) == 'u'){
                count ++;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxVowels("weallloveyou", 7));
        System.out.println(maxVowels("novowels", 1));
    }
}
