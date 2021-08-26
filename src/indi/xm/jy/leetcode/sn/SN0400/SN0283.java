package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0283
 * @Author: albert.fang
 * @Description: 移动零
 * @Date: 2021/8/26 11:25
 */
public class SN0283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index ++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test(){
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{3,1,5,3,12});
    }
}
