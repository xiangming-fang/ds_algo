package indi.xm.jy.leetcode.sn.SN0400;

import indi.xm.jy.leetcode.data_structure.array.Array;
import indi.xm.jy.leetcode.data_structure.heap.MaxHeap;
import org.junit.Test;

/**
 * 数据流的中位数
 */
public class SN0295 {

    private MaxHeap<Double> maxHeap;

    /** initialize your data structure here. */
    public SN0295() {
        maxHeap = new MaxHeap<>();
    }

    public void addNum(int num) {
        maxHeap.add((double)num);
    }

    public double findMedian() {
        int len = maxHeap.getSize();
        Array<Double> list = new Array<>();
        double mid;
        if (len % 2 == 1){
            for (int i = 0; i < len/2; i++) {
                list.addLast(maxHeap.remove());
            }
            mid = maxHeap.remove();
            list.addLast(mid);
        }
        else {
            for (int j = 0; j < (len - 1)/2; j++) {
                list.addLast(maxHeap.remove());
            }
            Double midO = maxHeap.remove();
            Double midT = maxHeap.remove();
            list.addLast(midO);
            list.addLast(midT);
            mid = (midO + midT) / 2;
        }
        for (int i = 0; i < list.getSize(); i++) {
            maxHeap.add(list.get(i));
        }
        return mid;
    }

    @Test
    public void test(){
        SN0295 sn0295 = new SN0295();
        sn0295.addNum(1);
        System.out.println(sn0295.findMedian());
        sn0295.addNum(2);
        System.out.println(sn0295.findMedian());
        sn0295.addNum(3);
        sn0295.addNum(4);
        System.out.println(sn0295.findMedian());
        sn0295.addNum(6);
        sn0295.addNum(8);
        sn0295.addNum(8);
        sn0295.addNum(9);
        sn0295.addNum(9);
        sn0295.addNum(10);
        sn0295.addNum(15);
        sn0295.addNum(17);
        sn0295.addNum(17);
        sn0295.addNum(17);
        System.out.println(sn0295.findMedian());
    }
}
