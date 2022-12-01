package indi.xm.ds_algo.leetcode.sn.SN1000;

import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0786
 * @Author: albert.fang
 * @Description: 第 K 个最小的素数分数
 * @Date: 2021/11/29 19:23
 */
public class SN0786 {
    // 最大堆
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 维护一个最大堆
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[0] * 1.0 / b[1],a[0] * 1.0/a[1]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                if (maxHeap.size() < k || maxHeap.peek()[0] * 1.0 / maxHeap.peek()[1] > a * 1.0 / b){
                    if (maxHeap.size() == k) {
                        maxHeap.poll();
                    }
                    maxHeap.offer(new int[]{a,b});
                }
            }
        }
        return maxHeap.peek();
    }
}
