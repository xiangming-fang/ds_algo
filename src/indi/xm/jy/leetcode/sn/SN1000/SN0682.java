package indi.xm.jy.leetcode.sn.SN1000;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/25 17:46
 * @description: 682.棒球比赛
 * ["5","2","C","D","+"]
 */
public class SN0682 {
    public int calPoints(String[] ops) {
        if (ops == null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            // 如果是数字的话，则直接入栈
            if (op.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")){
                stack.push(Integer.valueOf(op));
                continue;
            }
            // 前一轮无效
            if (op.equals("C")){
                stack.pop();
                continue;
            }
            // 前一轮的double
            if (op.equals("D")){
                Integer peek = stack.peek();
                stack.push(2 * peek);
                continue;
            }
            // 前两轮有效的分数和（这个是难点）
            if (op.equals("+")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp1 + temp2);
            }
        }
        int result = 0;
        for (Integer integer : stack) {
            result += integer;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("4".matches("^(\\-|\\+)?\\d+(\\.\\d+)?$"));
    }
}
