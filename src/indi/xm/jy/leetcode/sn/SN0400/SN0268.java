package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

// 丢失的数字
public class SN0268 {
    public int missingNumber(int[] nums) {
        int[] helpArr = new int[nums.length + 1];
        for (int i = 0; i < helpArr.length; i++) {
            helpArr[i] = i;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= helpArr[i];
        }
        res ^= helpArr[nums.length];
        return res;
    }

    @Test
    public void test(){
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }
}
