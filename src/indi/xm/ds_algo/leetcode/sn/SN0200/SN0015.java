package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0015
 * @Author: albert.fang
 * @Description: 三数之和
 * @Date: 2021/8/27 19:29
 */
public class SN0015 {

    // 双指针 yyds
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 对i方向去重
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if (nums[left] + nums[right] + nums[i] < 0){
                    left ++;
                }
                else if (nums[left] + nums[right] + nums[i] > 0){
                    right --;
                }
                else {
                    List<Integer> an = new ArrayList<>();
                    an.add(nums[i]);
                    an.add(nums[left]);
                    an.add(nums[right]);
                    res.add(an);
                    // 这两个while 循环很重要分别是对left 和 对right方向去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right --;
                    left --;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-2,0,0,0,2,2,2}));
    }
}
