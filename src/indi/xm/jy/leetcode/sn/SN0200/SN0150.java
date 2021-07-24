package indi.xm.jy.leetcode.sn.SN0200;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/26 10:53
 * @description: 150.逆波兰表达式求值
 */
public class SN0150 {
    // 思路：
    // 1、遍历tokens数组，是数字的话则直接入栈。
    // 2、碰见符号（+、-、*、/）则从栈中弹出两个数，将结果压入栈中
    // 后缀表达式的优点是不需要考虑运算符的优先级，只需要按顺序进行运算即可
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        // 创建一个数栈
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // 如果是数字的话
            if (token.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")){
                stack.push(Integer.valueOf(token));
            }
            else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num = 0;
                switch (token) {
                    case "+":
                        num = num2 + num1;
                        break;
                    case "-":
                        num = num2 - num1;
                        break;
                    case "*":
                        num = num2 * num1;
                        break;
                    case "/":
                        num = num2 / num1;
                        break;
                }
                stack.push(num);
            }
        }
        // 在栈中的最后一个元素就是最后的计算结果
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] test = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(test));
    }
}
