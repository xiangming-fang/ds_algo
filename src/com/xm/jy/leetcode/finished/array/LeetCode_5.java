package com.xm.jy.leetcode.finished.array;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author: albert.fang
 * @date: 2020/7/20 14:23
 * @description: 力扣第167题：两数之和 II - 输入有序数组
 */
public class LeetCode_5 {
    public static void main(String[] args) {
        int[] numbers = {2,4,6};
        for (int i : Objects.requireNonNull(twoSum(numbers, 8))) {
            System.out.println(i);
        }
    }
    private static int[] twoSum(int[] numbers, int target) {
        for (int k = 0; k < numbers.length; k++) {
            int i = k + 1;
            int j = numbers.length - 1;
            while (i < j){
                int mid = (i+j)/2;
                if (numbers[mid] + numbers[k] == target){
                    return new int[]{k+1,mid+1};
                }else if (numbers[mid] + numbers[k] > target){
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
            }
            if (numbers[i] + numbers[k] == target){
                return new int[]{k+1,i+1};
            }
        }
        return new int[]{-1,-1};
    }
}
