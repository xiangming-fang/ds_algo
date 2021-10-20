package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0453
 * @Author: albert.fang
 * @Description: 最小操作次数使数组元素相等
 * @Date: 2021/10/20 13:05
 */
public class SN0453 {

    // 贪心思想
    // 方法一：暴力贪心 （超时了……）
    public int minMoves01(int[] nums) {

        return minMoves(nums,0);
    }

    private int minMoves(int[] nums,int count){
        // 1、判断nums是否已经满足全部元素相等
        if (isEquals(nums)){
            return count;
        }

        // 2、找到nums里最大元素的下标，如果存在多个相等的最大元素，那么随机返回一个即可
        int maxIndex = getMaxIndex(nums);

        // 补充 2.1 找到nums里最大最小之间相差几
        int maxAndMinDiff = getMaxAndMinDiff(nums, maxIndex);

        // 3、遍历将非最大元素下标的值全部 + maxAndMinDiff
        plusNums(nums,maxIndex,maxAndMinDiff);

        // 重复1，2，3步骤即可]
        return minMoves(nums,count + maxAndMinDiff);
    }

    private int getMaxAndMinDiff(int[] nums,int maxIndex){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
        }
        return nums[maxIndex] - min;
    }


    private boolean isEquals(int[] nums){
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp){
                return false;
            }
        }
        return true;
    }

    private int getMaxIndex(int[] nums){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void plusNums(int[] nums,int maxIndex,int maxAndMinDiff){
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex){
                nums[i] += maxAndMinDiff;
            }
        }
    }

    // 逆向思维，n-1个需要 + 1相当于 只有一个需要减去1
    public int minMoves(int[] nums) {
        int res = 0;
        int minValue = Arrays.stream(nums).min().getAsInt();
        for (int num : nums) {
            res += num - minValue;
        }
        return res;
    }

    @Test
    public void test(){
//        System.out.println(minMoves(new int[]{1, 2, 3}));
//        System.out.println(minMoves(new int[]{2, 3, 4}));
//        System.out.println(minMoves(new int[]{2, 2, 2}));
//        System.out.println(minMoves(new int[]{1,1000000000}));
        System.out.println(minMoves(new int[]{-1000000000,-1}));
//        System.out.println(getMaxIndex(new int[]{1,1000000000}));
    }
}
