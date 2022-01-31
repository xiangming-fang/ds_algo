package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0334
 * @Author: albert.fang
 * @Description: 334. 递增的三元子序列
 * @Date: 2022/1/12 9:05
 */
public class SN0334 {

    // 能解决判断是否存在三元组，但是不能找到具体的三元组
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) a = num;
            else if (num <= b) b = num;
            else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        increasingTriplet(new int[]{1,2,0,8,9});
    }

}
