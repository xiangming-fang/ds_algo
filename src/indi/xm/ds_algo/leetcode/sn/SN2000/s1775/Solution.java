package indi.xm.ds_algo.leetcode.sn.SN2000.s1775;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: albert.fang
 * @Description: 通过最少操作次数使数组的和相等
 * @Date: 2022/12/8 15:03
 */
public class Solution {

    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (6*n < m || 6*m < n) return -1;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        // 我们就是要让 nums1 加， nums2 减
        if (sum1 > sum2) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        // idx 表示变化差值，value 表示这个差值变化了几次
        int[] cnt = new int[6];
        for (int num : nums1) cnt[6-num]++;
        for (int num : nums2) cnt[num-1]++;
        int d = Math.abs(sum2 - sum1);
        // 我们优先改变差值变化最大的
        int ans = 0;
        for (int i = 5; i > 0;i --){
            if (cnt[i] * i >= d) {
                ans += (d + i - 1)/i;
                break;
            }
            d -= cnt[i] * i;
            ans += cnt[i];
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(minOperations(new int[]{6, 6}, new int[]{1}));
    }

}
