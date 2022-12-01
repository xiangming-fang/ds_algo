package indi.xm.ds_algo.leetcode.sn.SN1000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0747
 * @Author: albert.fang
 * @Description: 747. 至少是其他数字两倍的最大数
 * @Date: 2022/1/13 9:07
 */
public class SN0747 {

    public int dominantIndex(int[] nums) {
        // a 第一大，b第二大
        int a = -1,b = -1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= a) {
                b = a;
                a = nums[i];
                maxIndex = i;
            }
            // 这步很关键
            else if (nums[i] > b){
                b = nums[i];
            }
        }
        if ((b << 1) > a) return -1;
        return maxIndex;
    }
}
