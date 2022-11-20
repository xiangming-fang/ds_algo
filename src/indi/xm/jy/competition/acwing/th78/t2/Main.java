package indi.xm.jy.competition.acwing.th78.t2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * t2
 */
public class Main {

    // 思路：栈
    // 1、遍历字符串s，当前所属遍历位置为i
    // 2、如果栈为空，或者栈顶元素和字符串当前遍历位置i相等，则栈顶元素弹出
    // 3、否则将i位置元素push到栈顶元素
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stk.isEmpty()) stk.push(s.charAt(i));
            else {
                if (s.charAt(i) == stk.peek()) stk.pop();
                else stk.push(s.charAt(i));
            }
        }
        for (Character character : stk) {
            System.out.print(character);
        }
    }

    // babbbbabbabbbababbabbbbbbabaabaababaaabbbbbabbbbaaaaabbaaabbaabaabbbbabbbababbabaaabbababaaababbbaaa

}
