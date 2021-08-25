package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0189
 * @Author: albert.fang
 * @Description: 旋转数组
 * @Date: 2021/8/25 14:04
 */
public class SN0189 {


    // 3次翻转数组
    // 1、整体翻转
    // 2、0，k-1
    // 3、k,nums.length-1
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k-1);
        reserve(nums,k,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private void reserve(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    // 常规解法
    public void rotate01(int[] nums, int k) {
        int rs = k % nums.length;
        int[] temp = new int[nums.length];
        System.arraycopy(nums,0,temp,0,nums.length);
        for (int i = 0; i < nums.length; i++) {
            int step = (i + rs) % nums.length;
            nums[step] = temp[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test(){
        rotate01(new int[]{1,2,3,4,5,6},13);
        rotate(new int[]{1,2,3,4,5,6},13);
    }
}
