package com.xm.jy.leetcode.finished.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/7/20 14:23
 * @description: 力扣第739题：每日温度
 */
public class DailyTemperatures {

    private static int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0){
            return null;
        }
        Stack<String> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (stack.size() == 0){
                stack.push(i +"," + T[i]);
            }
            else {
                Integer index = Integer.valueOf(stack.peek().split(",")[0]);
                Integer value = Integer.valueOf(stack.peek().split(",")[1]);
                while (T[i] > value){
                    result[index] = i - index;
                    // 栈顶元素出栈
                    stack.pop();
                    if (stack.size() > 0){
                        index = Integer.valueOf(stack.peek().split(",")[0]);
                        value = Integer.valueOf(stack.peek().split(",")[1]);
                    }else {
                        break;
                    }
                }
                // 入栈
                stack.push(i + "," + T[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int i : dailyTemperatures(t)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
