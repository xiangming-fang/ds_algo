package indi.xm.jy.leetcode.sn.SN0600;


import indi.xm.jy.leetcode.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

// 630. 课程表 III
public class SN0603 {

    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.addAll(Arrays.asList(courses));
        int count = 0;
        int res = 0;
        int len = minHeap.size();
        for (int i = 0; i < len; i++) {
            int[] poll = minHeap.poll();
            res += poll[0];
            if (res <= poll[1]){
                count ++;
            }
            else {
                break;
            }
        }
        return count;
    }

    @Test
    public void test(){
//        StringUtils.replaceArr("[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]");
//        StringUtils.replaceArr("[[5,5],[4,6],[2,6]]");
        System.out.println(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
//        System.out.println(scheduleCourse(new int[][]{{5,5},{4,6},{2,6}}));
    }
}
