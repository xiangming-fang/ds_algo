package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0557
 * @Author: albert.fang
 * @Description: 反转字符串中的单词 III
 * @Date: 2021/8/27 14:18
 */
public class SN0557 {
    public String reverseWords01(String s) {
        String[] ns = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String n : ns) {
            sb.append(reverseString(n.toCharArray())).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
    private String reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right){
            swap(s,left,right);
            left ++;
            right --;
        }
        return String.valueOf(s);
    }

    private void swap(char[] s,int l,int r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    public String reverseWords(String s) {

        Stack<Character> stack = new Stack<>();
        int p = 0;
        StringBuilder ret = new StringBuilder();
        while ( p < s.length() ){
            char c = s.charAt(p++);
            if ( c == ' '){
                while (!stack.isEmpty()){
                    ret.append(stack.pop());
                }
                ret.append(c);
            }
            else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            ret.append(stack.pop());
        }

        return ret.toString();

    }

    @Test
    public void test(){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
