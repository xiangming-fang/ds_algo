package indi.xm.ds_algo.leetcode.sn.SN1000.s0795;

/**
 * @Author: albert.fang
 * @Description: 区间子数组个数
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = -1;
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > right) {
                ans += (1+(j-i-1)) * (j-i-1)/2;
                i = j;
            }
        }
        ans += (1+(nums.length-i-1)) * (nums.length-i-1)/2;
        return ans;
    }
}
