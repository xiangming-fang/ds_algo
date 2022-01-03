package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0567
 * @Author: albert.fang
 * @Description: 字符串的排列
 * @Date: 2021/9/1 14:22
 */
public class SN0567 {
    public boolean checkInclusion01(String s1, String s2) {
        // s1 的长度就是滑动窗口的大小
        int swBreadth = s1.length();
        int right;
        for (int left = 0; left < s2.length() - swBreadth + 1; left++) {
            right = left + swBreadth - 1;
            // s2 当前窗口里的子字符串
            String str = s2.substring(left, right + 1);
            if (checkStrContainSameChar(str,s1)) {
                return true;
            }
        }
        return false;
    }

    // 比较两个字符串是否包含相同字符
    // ab == ba
    // abc == acb == bca
    // abb == bba !== aab 这个特别注意，字符可能重复
    private boolean checkStrContainSameChar(String str1,String str2){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }
            else {
                map.put(c,1);
            }
        }
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c) - 1);
        }
        long count = map.values().stream().filter(v -> v != 0).count();
        return count == 0;
    }


    public boolean checkInclusion02(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int windowSize = s1.length();

        int len = s2.length();

        for (int i = 0; i <= len - windowSize; i++) {
            if (checkSame(s1,s2.substring(i,i + windowSize))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSame(String a,String b){
        if (a.length() != b.length()) return false;
        int len = a.length();
        int[] pos = new int[26];
        for (int i = 0; i < len; i++) {
            pos[a.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < len; i++) {
            pos[b.charAt(i) - 'a'] --;
            if (pos[b.charAt(i) - 'a'] < 0) return false;
        }
        for (int po : pos) {
            if (po != 0) return false;
        }
        return true;
    }


    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;
        int[] h1 = new int[26];
        int[] h2 = new int[26];
        for (int i = 0; i < len1; i++) {
            h1[s1.charAt(i) - 'a'] ++;
            h2[s2.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(h1,h2)) return true;
        for (int i = len1; i < len2; i++) {
            h2[s2.charAt(i) - 'a'] ++;
            h2[s2.charAt(i - len1) - 'a'] --;
            if (Arrays.equals(h1,h2)) return true;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(checkInclusion("ab", "ab"));
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
