package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

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
    public boolean checkInclusion(String s1, String s2) {
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

    @Test
    public void test(){
//        System.out.println(checkInclusion("ab", "ab"));
//        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
