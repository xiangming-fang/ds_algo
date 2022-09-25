package indi.xm.jy.leetcode.sn.SN0400;

import indi.xm.jy.leetcode.data_structure.array.Array;
import indi.xm.jy.leetcode.data_structure.heap.MaxHeap;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 */
public class SN0295 {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public SN0295() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    @Test
    public void test(){
        SN0295 sn0295 = new SN0295();
        sn0295.addNum(1);
        sn0295.addNum(2);
        System.out.println(sn0295.findMedian());
        sn0295.addNum(3);
        System.out.println(sn0295.findMedian());
    }
}
