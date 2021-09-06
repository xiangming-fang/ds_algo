package indi.xm.jy.leetcode.sn.SN0200;

import indi.xm.jy.leetcode.sort.QuickSort;

import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0169
 * @Author: albert.fang
 * @Description: 多数元素
 * @Date: 2021/9/6 18:40
 */
public class SN0169 {
    // 在这题中排好序之后，中位数肯定就是众数
    public int majorityElement01(int[] nums) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        return nums[nums.length / 2];
    }
}
