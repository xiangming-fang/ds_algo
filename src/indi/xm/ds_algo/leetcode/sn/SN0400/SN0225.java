package indi.xm.ds_algo.leetcode.sn.SN0400;

import java.util.LinkedList;

/**
 * @author: albert.fang
 * @date: 2020/8/26 9:58
 * @description: 225.用队列实现栈
 */
public class SN0225 {

    LinkedList<Integer> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public SN0225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (q1.size() == 0 && q2.size() == 0){
            q1.add(x);
        }
        else if (q1.size() != 0){
            q1.add(x);
        }
        else{
            q2.add(x);
        }
    }


    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.size() > 0){
            int length = q1.size();
            for (int i = 0; i < length - 1; i++) {
                q2.add(q1.poll());
            }
            return q1.poll();
        }
        else if (q2.size() > 0){
            int length = q2.size();
            for (int i = 0; i < length - 1; i++) {
                q1.add(q2.poll());
            }
            return q2.poll();
        }
        throw new RuntimeException("出队错误");
    }

    /** Get the top element. */
    public int top() {
        if (q1.size() > 0){
            int length = q1.size();
            for (int i = 0; i < length - 1; i++) {
                q2.add(q1.poll());
            }
            int topValue = q1.peek();
            q2.add(q1.poll());
            return topValue;
        }
        else if (q2.size() > 0){
            int length = q2.size();
            for (int i = 0; i < length - 1; i++) {
                q1.add(q2.poll());
            }
            int topValue = q2.peek();
            q1.add(q2.poll());
            return topValue;
        }
        throw new RuntimeException("获取头部元素有误");
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }

    public static void main(String[] args) {
        SN0225 stack = new SN0225();
        stack.push(23);
        stack.push(34);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
