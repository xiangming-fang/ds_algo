package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0295_03
 * @Author: albert.fang
 * @Description: 数据流的中位数
 * @Date: 2021/8/27 13:37
 */
public class SN0295_03 {

    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public SN0295_03() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if (min.size() > max.size()){
            max.add(min.remove());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()){
            return (double)(max.peek() + min.peek())/2;
        }
        return max.peek();
    }

    @Test
    public void test(){
        SN0295_03 sn0295 = new SN0295_03();
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
