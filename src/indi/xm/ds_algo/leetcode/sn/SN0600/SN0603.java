package indi.xm.ds_algo.leetcode.sn.SN0600;


import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

// 630. 课程表 III
public class SN0603 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> a[1] - b[1]);
        // 最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int sum = 0;
        for (int[] cours : courses) {
            int f = cours[0],s = cours[1];
            sum += f;
            maxHeap.add(f);
            // 让maxheap 里的总和始终小于等于 s
            if (sum > s) {
                sum -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }

    @Test
    public void test(){
//        StringUtils.replaceArr("[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]");
//        StringUtils.replaceArr("[[5,5],[4,6],[2,6]]");
//        System.out.println(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println(scheduleCourse(new int[][]{{5,5},{4,6},{2,6}}));
    }
}
