package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0053
 * @Author: albert.fang
 * @Description: 最大子序和
 * @Date: 2021/8/26 17:10
 */
public class SN0053 {

    public int maxSubArray01(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    // 20210907 dp 转移 自己写的
    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{0}));
        System.out.println(maxSubArray(new int[]{-7}));
        System.out.println(maxSubArray(new int[]{-2,1}));
    }
}
