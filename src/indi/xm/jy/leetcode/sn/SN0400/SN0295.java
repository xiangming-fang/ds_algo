package indi.xm.jy.leetcode.sn.SN0400;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数据流的中位数
 */
public class SN0295 {

    private ArrayList<Integer> list;

    /** initialize your data structure here. */
    public SN0295() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        if (list.size()%2 == 0) {
            return (double)(list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        }
        return list.get(list.size() / 2);
    }
}
