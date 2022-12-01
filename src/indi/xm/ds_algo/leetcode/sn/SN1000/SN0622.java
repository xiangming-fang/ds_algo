package indi.xm.ds_algo.leetcode.sn.SN1000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0622
 * @Author: albert.fang
 * @Description: 循环队列的设计
 * @Date: 2022/11/16 10:42
 */
public class SN0622 {

}

class MyCircularQueue {

    int N;

    int[] queue;

    int hh = 0;
    int tt = 0;
    int size = 0;

    public MyCircularQueue(int k) {
        N = k;
        queue = new int[N];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[tt++] = value;
        if (tt == N) tt = 0;
        size ++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        hh ++;
        if (hh == N) hh = 0;
        size --;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[hh];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        if (tt == 0) return queue[N-1];
        else return queue[tt-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == N;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */