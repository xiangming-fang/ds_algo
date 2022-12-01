package indi.xm.ds_algo.leetcode.sn.SN0200;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0035
 * @Author: albert.fang
 * @Description: 搜索插入位置
 * @Date: 2021/8/24 18:29
 */
public class SN0035 {

    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target){
            return 0;
        }
        if (nums[nums.length - 1] < target){
            return nums.length;
        }
        return searchInsert(0, nums.length - 1, nums, target);
    }

    private int searchInsert(int start, int end, int[] nums, int target) {
        int mid = start + (end - start) / 2;
        // 终止条件
        if (target == nums[mid]){
            return mid;
        }
        else if (target > nums[mid] && target < nums[mid + 1]){
            return mid + 1;
        }
        else if (target < nums[mid] && target > nums[mid - 1]){
            return mid;
        }
        // 更小问题
        if (target > nums[mid]){
            return searchInsert(mid + 1,end,nums,target);
        }
        else if (target < nums[mid]){
            return searchInsert(start,mid-1,nums,target);
        }
        return 0;
    }

    // 暴力解法
    public int searchInsert01(int[] nums, int target) {
        if (target > nums[nums.length-1]){
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                return i;
            }
            if (target > nums[i] && target < nums[i+1]){
                return i+1;
            }
        }
        return 0;
    }

    public int searchInsert02(int[] nums, int target) {
        int left = 0,right = nums.length - 1,mid;
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
        // 核心思想哦
        return right + 1;
    }

}
