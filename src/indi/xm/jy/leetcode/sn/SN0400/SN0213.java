package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0213
 * @Author: albert.fang
 * @Description: 家劫舍 II
 * @Date: 2021/8/26 15:41
 */
public class SN0213 {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        // 偷第一家，不偷最后一家
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        // 偷最后一家，不偷第一家
        int[] dpLast = new int[nums.length];
        dpLast[1] = nums[1];
        dpLast[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < dpLast.length; i++) {
            dpLast[i] = Math.max(dpLast[i-1],dpLast[i-2] + nums[i]);
        }
        return Math.max(dp[dp.length-2],dpLast[dpLast.length-1]);
    }

    @Test
    public void test(){
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,1,2}));
        System.out.println(rob(new int[]{2,1}));
        System.out.println(rob(new int[]{1}));
    }
}
