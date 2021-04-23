package com.xm.jy.leetcode.offer;

import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/25 16:35
 * @description: 剑指 Offer 09. 用两个栈实现队列
 */
public class Offer09 {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public Offer09() {

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
 * Your Offer09 object will be instantiated and called as such:
 * Offer09 obj = new Offer09();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
