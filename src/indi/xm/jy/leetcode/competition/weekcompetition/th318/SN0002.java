package indi.xm.jy.leetcode.competition.weekcompetition.th318;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0002 {

    // 前缀和 + 双指针找 最大无重复子串 截取k
    public long maximumSubarraySum(int[] nums, int k) {
        long  res = 0;
        if (k > nums.length) return res;
        long[] sum = new long[nums.length+1];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int[] hash = new int[100010];
        for (int i = 0,j = 0; i < nums.length; i++) {
            hash[nums[i]] ++;
            while ((j < i && hash[nums[i]] > 1)){
                hash[nums[j++]]--;
            }
            if (i - j + 1 >= k){
                if (i - k < 0) res = Math.max(res,sum[i]);
                else res = Math.max(res,sum[i] - sum[i - k]);
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(maximumSubarraySum(new int[]{4,4,4}, 3));
        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 8, 10}, 3));
    }
}
