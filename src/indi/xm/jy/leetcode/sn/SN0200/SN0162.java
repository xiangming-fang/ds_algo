package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0162
 * @Author: albert.fang
 * @Description: 寻找峰值
 * @Date: 2021/9/15 9:56
 */
public class SN0162 {

    // 二分
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (nums.length == 1){
            return 0;
        }
        if (nums[0] > nums[1]){
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]){
            return len - 1;
        }
        return findPeakElement(0,nums.length - 1,nums);
    }

    private int findPeakElement(int left, int right, int[] nums) {
        int mid = left + (right - left)/2;
        // 下坡
        if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]){
            return findPeakElement(left,mid,nums);
        }
        // 上坡
        else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]){
            left = mid;
            return findPeakElement(left,right,nums);
        }
        // 答案
        else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
            return mid;
        }
        // 在谷底
        else if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]){
            left = mid;
            return findPeakElement(left,right,nums);
        }
        return -1;
    }

    // 方法一：模拟（直接找到最大值即可）
    public int findPeakElement01(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]){
                idx = i;
            }
        }
        return idx;
    }

    @Test
    public void test(){
//        System.out.println(findPeakElement(new int[]{1,2,3,1}));
//        System.out.println(findPeakElement(new int[]{1}));
//        System.out.println(findPeakElement(new int[]{2,1}));
//        System.out.println(findPeakElement(new int[]{1,2}));
        System.out.println(findPeakElement(new int[]{1,2,1,2,1}));
    }
}
