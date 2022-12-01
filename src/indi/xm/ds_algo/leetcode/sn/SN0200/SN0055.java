package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0055
 * @Author: albert.fang
 * @Description: 跳跃游戏
 * @Date: 2021/8/27 15:40
 */
public class SN0055 {

    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] + i >= end){
                end = i;
            }
        }
        return end == 0;
    }

    public boolean canJump01(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= distance){
                distance = Math.max(i + nums[i] , distance);
                if (distance >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{0,2,1,0,4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{2,0}));
        System.out.println(canJump(new int[]{2,5,0,0}));

    }
}
