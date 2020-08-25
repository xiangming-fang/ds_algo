package com.xm.jy.leetcode.finished.stack;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/25 16:35
 * @description: 用两个栈实现队列
 */
public class CQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        while (s2.size() > 0){
            s1.push(s2.pop());
        }
        s1.push(value);
    }

    public int deleteHead() {
        while (s1.size() > 0){
            s2.push(s1.pop());
        }
        if (s2.size() == 0){
            return -1;
        }
        return s2.pop();
    }

}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
