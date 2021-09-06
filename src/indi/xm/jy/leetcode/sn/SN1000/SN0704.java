package indi.xm.jy.leetcode.sn.SN1000;

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


    @Test
    public void test(){
//        System.out.println(search(new int[]{5}, 2));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 13));
    }
}
