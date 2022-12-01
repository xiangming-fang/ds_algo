package indi.xm.ds_algo.leetcode.sn.SN1000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0862
 * @Author: albert.fang
 * @Description: 和至少为k的最短子数组长度
 * @Date: 2022/10/26 17:05
 */
public class SN0862_1 {

    // tle
    // 提示1：假如存在，那么窗口最小应该从1开始，所以我们可以用一个会变动大小的窗口去找，第一个窗口里的和大于等于k的，则这个窗口的大小就是答案
    // x 窗口大小
    // sum 窗口的和
    public int shortestSubarray(int[] nums, int k) {
        int x = 1;
        int sum = 0;
        while (x <= nums.length){
            for (int i = 0; i < nums.length - x + 1; i++) {
                for (int j = i; j < i + x; j++) {
                    sum += nums[j];
                }
                if (sum >= k) return x;
                sum = 0;
            }
            x ++;
        }
        return -1;
    }


}
