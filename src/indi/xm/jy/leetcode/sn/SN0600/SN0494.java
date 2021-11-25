package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0494
 * @Author: albert.fang
 * @Description: 目标和
 * @Date: 2021/11/25 17:41
 */
public class SN0494 {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0);
        return count;
    }

    private void dfs(int[] nums, int target, int start) {

        if (start >= nums.length && getSum(nums) == target){
            count ++;
            return;
        }
        if (start >= nums.length){
            return;
        }

        for (int j = 0; j < 2; j++) {
            int temp = nums[start];
            if (j == 0){
                nums[start] = nums[start];
            }
            else {
                nums[start] = -nums[start];
            }
            dfs(nums,target,start + 1);
            // 回溯
            nums[start] = temp;
        }
    }


    private int getSum(int[] nums){
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }

    @Test
    public void test(){
//        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(findTargetSumWays(new int[]{1}, 1));
        System.out.println(findTargetSumWays(new int[]{2, 2, 2, 1, 1}, 6));
    }
}
