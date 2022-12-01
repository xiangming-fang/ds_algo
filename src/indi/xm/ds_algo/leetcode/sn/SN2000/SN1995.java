package indi.xm.ds_algo.leetcode.sn.SN2000;

import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1995
 * @Author: albert.fang
 * @Description: 1995. 统计特殊四元组
 * @Date: 2021/12/29 12:18
 */
public class SN1995 {
    public int countQuadruplets(int[] nums) {
        if (nums.length < 4) return -1;
        int ret = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) ret ++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>(160);
        System.out.println(map);
    }
}
