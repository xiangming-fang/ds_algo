package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0016
 * @Author: albert.fang
 * @Description: 最接近的三数之和
 * @Date: 2021/9/7 9:40
 */
public class SN0016 {

    // 注意指针移动的条件，使用三个值的临时和temp和目标值target作比较，才判断左右指针的移动的。
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        // 差值
        int dv = Math.abs(sum - target);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if (dv >= Math.abs(temp - target)){
                    sum = temp;
                    dv = Math.abs(temp - target);
                }
                if (temp > target){
                    right --;
                }
                else if (temp < target){
                    left ++;
                }
                else {
                    return target;
                }
            }
        }
        return sum;
    }

    @Test
    public void test(){
//        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0,2,1,-3}, 1));
    }
}
