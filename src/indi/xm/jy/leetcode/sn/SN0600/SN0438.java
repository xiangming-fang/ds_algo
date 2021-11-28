package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 找到字符串中所有字母异位词
public class SN0438 {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] memo = new int[26];
        int len = p.length();
        for (int i = 0; i < len; i++) {
            memo[p.charAt(i) - 'a'] ++;
        }
        for (int j = 0; j <= s.length() - len; j++) {
            for (int i = j; i < j + len; i++) {
                if (memo[s.charAt(i) - 'a'] != 0){
                    memo[s.charAt(i) - 'a'] --;
                }
            }
            if (!isFit(memo)){
                res.add(j);
            }
            Arrays.fill(memo,0);
            for (int i = 0; i < len; i++) {
                memo[p.charAt(i) - 'a'] ++;
            }
        }
        return res;
    }

    // false - 符合
    // true - 不符合
    private boolean isFit(int[] ans){
        return Arrays.stream(ans).anyMatch(v -> v != 0);
    }

    public List<Integer> findAnagrams02(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] memo = new int[26];
        int len = p.length();
        for (int i = 0; i < len; i++) {
            memo[p.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        for (int j = 0; j <= s.length() - len; j++) {
            if (j == 0){
                for (int i = j; i < j + len; i++) {
                    window[s.charAt(i) - 'a'] ++;
                }
            }else {
                window[s.charAt(j + len - 1) - 'a'] ++;
            }
            if (isFit(memo,window)) {
                res.add(j);
            }
            window[s.charAt(j) - 'a'] --;
        }
        return res;
    }

    // true 找到了
    // false 没找到
    private boolean isFit(int[] memo,int[] window){
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] != window[i]) return false;
        }
        return true;
    }


    @Test
    public void test(){
        System.out.println(findAnagrams02("cbaebabacd", "abc"));
    }
}
