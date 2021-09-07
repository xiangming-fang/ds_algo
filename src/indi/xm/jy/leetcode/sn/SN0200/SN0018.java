package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0018
 * @Author: albert.fang
 * @Description: 四数之和
 * @Date: 2021/9/5 14:39
 */
public class SN0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {

            // 重复
            if (first > 0 &&nums[first] == nums[first - 1]){
                continue;
            }

            for (int second = first + 1; second < nums.length; second++) {
                // 重复
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                int left = second + 1;
                int right = nums.length - 1;
                while (left < right){
                    if (nums[first] + nums[left] + nums[right] + nums[second] < target){
                        left ++;
                    }
                    else if (nums[first] + nums[left] + nums[right] + nums[second] > target){
                        right --;
                    }
                    else {
                        List<Integer> single = new ArrayList<>();
                        single.add(nums[first]);
                        single.add(nums[second]);
                        single.add(nums[left]);
                        single.add(nums[right]);
                        res.add(single);
                        while (right > left && nums[left] == nums[left + 1]) left ++;
                        while (right > left && nums[right] == nums[right - 1]) right --;
                        right --;
                        left ++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(fourSum(new int[]{-3,-1,0,2,4,5}, 0));
        System.out.println(fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
    }
}
