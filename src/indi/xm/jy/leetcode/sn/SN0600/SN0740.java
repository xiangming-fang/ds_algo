package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0740
 * @Author: albert.fang
 * @Description: 删除并获得点数
 * @Date: 2021/8/26 17:02
 */
public class SN0740 {

    // 这道题可以转化成之前的打家劫舍
    public int deleteAndEarn(int[] nums) {
        int maxValue = -1;
        for (int num : nums) {
            maxValue = Math.max(maxValue,num);
        }
        int[] sum = new int[maxValue+1];
        for (int num : nums) {
            sum[num] = sum[num] + num;
        }
        return rob(sum);
    }

    private int rob(int[] nums) {
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
        System.out.println(deleteAndEarn(new int[]{3,4,2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
