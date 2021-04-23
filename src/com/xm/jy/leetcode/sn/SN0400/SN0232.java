package com.xm.jy.leetcode.sn.SN0400;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/25 17:25
 * @description: 232.用栈实现队列
 */
public class SN0232 {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public SN0232() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (s2.size() > 0){
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (s1.size() > 0){
            s2.push(s1.pop());
        }
        if (empty()){
            return -1;
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (s1.size() > 0){
            s2.push(s1.pop());
        }
        if (empty()){
            return -1;
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        while (s1.size() > 0){
            s2.push(s1.pop());
        }
        if (s2.size() == 0){
            return true;
        }
        return false;
    }
}
