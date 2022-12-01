package indi.xm.ds_algo.leetcode.sn.SN1500;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/25 17:16
 * @description: 1047.删除字符串中所有相邻重复项
 */
public class SN1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.equals("")){
            return S;
        }
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (stack.size() == 0){
                stack.push(aChar);
            }
            else if (stack.peek().equals(aChar)){
                stack.pop();
            }
            else {
                stack.push(aChar);
            }
        }
        int size = stack.size();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

}
