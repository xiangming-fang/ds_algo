package indi.xm.jy.leetcode.Interview;

import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.Interview
 * @ClassName: Interview1714
 * @Author: albert.fang
 * @Description: 最小的K个数
 * @Date: 2021/9/3 9:39
 */
public class Interview1714 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int s : arr) {
            pq.offer(s);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
