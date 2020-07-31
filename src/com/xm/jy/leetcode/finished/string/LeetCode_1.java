package com.xm.jy.leetcode.finished.string;

import java.util.HashMap;

/**
 * @author: albert.fang
 * @date: 2020/7/20 10:21
 * @description: 力扣第242题：有效的字母异位词
 */
public class LeetCode_1 {
    public static void main(String[] args) {
        System.out.println(isOrNotValidLetter("ba","ab"));
    }

    private static boolean isOrNotValidLetter(String s,String t){
        if (s.length() != t.length()){
            return false;
        }
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        int[] ints = new int[26];
        for (char char_s : chars_s) {
            int index = (int)char_s - 97;
            ints[index] ++;
        }
        for (char char_t : chars_t) {
            int index = (int)char_t - 97;
            if (ints[index] == 0){
                return false;
            }
            ints[index] --;
        }
        for (int anInt : ints) {
            if (anInt > 0){
                return false;
            }
        }
        return true;
    }
}
