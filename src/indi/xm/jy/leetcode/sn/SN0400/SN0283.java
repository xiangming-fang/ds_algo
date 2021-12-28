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
    public void moveZeroes01(int[] nums) {
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

    public void moveZeroes(int[] nums) {
        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                continue;
            }
            nums[++p] = nums[i];
        }
        while (++p < nums.length){
            nums[p] = 0;
        }
    }

    @Test
    public void test(){
        int[] param = {0, 1, 0, 3, 12};
        int[] param1 = new int[]{3,1,5,3,12};
        moveZeroes(param);
        moveZeroes(param1);
        System.out.println(Arrays.toString(param));
        System.out.println(Arrays.toString(param1));
    }
}
