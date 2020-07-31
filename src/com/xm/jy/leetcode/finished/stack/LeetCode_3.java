package com.xm.jy.leetcode.finished.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/7/20 13:45
 * @description: 力扣第20题：有效的括号
 */
public class LeetCode_3 {
    static HashMap<Character,Character> bracket = new HashMap<Character,Character>(){
        {
            put('(',')');
            put('[',']');
            put('{','}');
        }
    };
    public static void main(String[] args) {
        System.out.println(isValid(""));
    }
    private static boolean isValid(String s) {
        if (s.length() == 0){
            return true;
        }
        if (s.length()%2 == 1 || !bracket.containsKey(s.charAt(0))){
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (char c : s.toCharArray()) {
            if (bracket.containsKey(c)){
                linkedList.push(c);
            }else {
                if ( bracket.get(linkedList.pop()) != c){
                    return false;
                }
            }
        }
        return linkedList.size() == 0;
    }
}
