package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0198
 * @Author: albert.fang
 * @Description: 打家劫舍
 * @Date: 2021/8/26 15:17
 */
public class SN0198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (dp.length == 1){
            return dp[0];
        }
        dp[1] = Math.max(nums[1],nums[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[dp.length-1];
    }

    @Test
    public void test(){
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,1,2}));
    }
}
