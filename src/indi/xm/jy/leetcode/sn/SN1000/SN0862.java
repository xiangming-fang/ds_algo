package indi.xm.jy.leetcode.sn.SN1000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0862
 * @Author: albert.fang
 * @Description: 和至少为k的最短子数组长度
 * @Date: 2022/10/26 17:05
 */
public class SN0862 {


    // tle
    // 1、依次将每个元素作为子数组起始元素
    // 2、当找到>=k的，立马返回
    public int shortestSubarray(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= k){
                res = 1;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= k) {
                    res = Math.min(res,j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}
