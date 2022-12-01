package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0045
 * @Author: albert.fang
 * @Description: 跳跃游戏 II
 * @Date: 2021/8/27 17:23
 */
public class SN0045 {

    public int jump(int[] nums) {
        int count = 0;
        int distance = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            distance = Math.max(distance,i + nums[i]);
            if (i == end){
                end = distance;
                count ++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{1}));
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

}
