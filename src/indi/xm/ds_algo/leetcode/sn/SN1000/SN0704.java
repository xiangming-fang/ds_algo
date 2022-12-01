package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0704
 * @Author: albert.fang
 * @Description: 二分查找
 * @Date: 2021/8/24 16:59
 */
public class SN0704 {
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    private int search(int[] nums,int start,int end,int target){
        int mid = start + (end - start) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (start > end){
            return -1;
        }
        if (nums[mid] < target){
            return search(nums, mid + 1, end, target);
        }
        return search(nums,start,mid - 1,target);
    }

    // 暴力解法
    public int search01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search02(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left >> 2);
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 整数二分模板
    public int search1(int[] nums, int target) {
        return bs(nums,0,nums.length - 1,target);
    }

    private int bs(int[] nums, int l, int r, int target) {
        while (l < r){
            int mid = l + (r-l)/2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l] == target ? l : -1;
    }


    @Test
    public void test(){
//        System.out.println(search(new int[]{5}, 2));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 13));
    }
}
