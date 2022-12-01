package indi.xm.ds_algo.leetcode.sn.SN0400;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0295_02
 * @Author: albert.fang
 * @Description: 数据流的中位数
 * @Date: 2021/8/27 13:25
 */
public class SN0295_02 {
    private PriorityQueue<Double> pq;

    /** initialize your data structure here. */
    public SN0295_02() {
        pq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        pq.add((double)num);
    }

    public double findMedian() {
        int len = pq.size();
        ArrayList<Double> list = new ArrayList<>();
        double mid;
        if (len % 2 == 1){
            for (int i = 0; i < len/2; i++) {
                list.add(pq.remove());
            }
            mid = pq.remove();
            list.add(mid);
        }
        else {
            for (int j = 0; j < (len - 1)/2; j++) {
                list.add(pq.remove());
            }
            Double midO = pq.remove();
            Double midT = pq.remove();
            list.add(midO);
            list.add(midT);
            mid = (midO + midT) / 2;
        }
        for (int i = 0; i < list.size(); i++) {
            pq.add(list.get(i));
        }
        return mid;
    }
}
