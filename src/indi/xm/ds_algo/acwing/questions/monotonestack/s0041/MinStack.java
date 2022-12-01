package indi.xm.ds_algo.acwing.questions.monotonestack.s0041;


import java.util.Stack;

/**
 * 包含min函数的栈
 * 在普通栈的模式下再维护一个单调递减的栈，用来快速得到当前栈中最小元素
 * 如何维护？这里记普通栈为stk、单调递减栈为minStk
 * 1、往stk中push新元素x的时候，判断一下x和minStk栈顶元素谁大谁小，如果minStk为空或者x比minStk栈顶元素小或者相等，则x也要push到minStk中。
 * 2、stk 弹出栈顶元素的时候，需要比较下，弹出元素 x 和 minStk 栈顶元素是否相等，相等的话则minStk跟着弹出
 */
public class MinStack {

    public Stack<Integer> stk = new Stack<>();
    public Stack<Integer> minStk = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (minStk.isEmpty() || minStk.peek() >= x) minStk.push(x);
        stk.push(x);
    }
    
    public void pop() {
        int x = top();
        if (x == minStk.peek()) minStk.pop();
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(3);
        minStack.push(-4);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}