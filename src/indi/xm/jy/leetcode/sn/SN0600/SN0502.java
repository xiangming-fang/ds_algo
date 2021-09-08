package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0502
 * @Author: albert.fang
 * @Description: IPO
 * @Date: 2021/9/8 9:57
 */
public class SN0502 {

    // 方法一：排序 + 最大堆
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] res = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            res[i][0] = capital[i];
            res[i][1] = profits[i];
        }
        Arrays.sort(res, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b - a);
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < profits.length && res[j][0] <= w ){
                priorityQueue.offer(res[j][1]);
                j ++;
            }
            if (!priorityQueue.isEmpty()){
                int value = priorityQueue.poll();
                w += value;
            }
        }
        return w;
    }

    @Test
    public void test(){
//        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
//        System.out.println(findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
//        System.out.println(findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
//        System.out.println(findMaximizedCapital(1, 0, new int[]{1, 2, 3}, new int[]{1, 1, 2}));
        System.out.println(findMaximizedCapital(11, 11, new int[]{1, 2, 3}, new int[]{11, 13, 12}));
    }

}
