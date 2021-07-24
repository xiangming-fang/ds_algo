package indi.xm.jy.leetcode.sn.SN1500;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/26 10:34
 * @description: 1003.检查替换后的词是否有效，有效字符串为“abc”
 */
public class SN1003 {
    public static boolean isValid(String S) {
        if (S == null || S.equals("")){
            return false;
        }
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        String vaild = "abc";
        for (char aChar : chars) {
            if (stack.size() < 2){
                stack.push(aChar);
            }
            else {
                // 先用两个临时变量存储栈顶和次栈顶元素，如果是无效字符，需要重新入栈
                Character top = stack.pop();
                Character ctop = stack.pop();
//                String temp = String.valueOf(ctop) + String.valueOf(top) + String.valueOf(aChar);
                String temp = ctop + String.valueOf(top) + aChar;
                // 如果是无有效的
                if (!temp.equals(vaild)){
                    stack.push(ctop);
                    stack.push(top);
                    stack.push(aChar);
                }
            }
        }
        // 如果最后栈为空，则输入的字符串是有效字符串
        if (stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabcbc"));
    }
}
