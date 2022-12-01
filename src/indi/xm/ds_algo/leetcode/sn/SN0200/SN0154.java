package indi.xm.ds_algo.leetcode.sn.SN0200;

/**
 * @author: albert.fang
 * @date: 2020/7/22 9:49
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * @description: 154. 寻找旋转排序数组中的最小值 II
 */
public class SN0154 {
    private static int minArray1(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if(i > 0){
                if (numbers[i - 1] > numbers[i]){
                    return numbers[i];
                }
            }
        }
        return numbers[0];
    }
}
