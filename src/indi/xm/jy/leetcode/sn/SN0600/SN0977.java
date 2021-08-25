package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0977
 * @Author: albert.fang
 * @Description: 有序数组的平方
 * @Date: 2021/8/25 13:17
 */
public class SN0977 {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int write = nums.length - 1;
        while (left <= right){
            if (nums[left] * nums[left] > nums[right] * nums[right]){
                result[write] = nums[left] * nums[left];
                left ++;
                write --;
            }
            else {
                result[write] = nums[right] * nums[right];
                right --;
                write --;
            }
        }
        return result;
    }

    // 暴力解法
    public int[] sortedSquares01(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(sortedSquares01(new int[]{-1, 0, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-1, 0, 2, 3, 4, 5})));
    }
}
