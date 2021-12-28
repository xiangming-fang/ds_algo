package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: albert.fang
 * @date: 2020/7/20 14:23
 * @description: 力扣第167题：两数之和 II - 输入有序数组
 */
public class SN0167 {
    public static void main(String[] args) {
        int[] numbers = {2,4,6};
        for (int i : Objects.requireNonNull(twoSum01(numbers, 8))) {
            System.out.println(i);
        }
    }
    private static int[] twoSum01(int[] numbers, int target) {
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

    // 双指针,numbers 有序
    public int[] twoSum02(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] < target){
                left ++;
            }
            else if (numbers[left] + numbers[right] > target){
                right --;
            }
            else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int left = 0,right = numbers.length - 1;
        while (left < right){
            int temp = numbers[left] + numbers[right];
            if (temp > target) right --;
            else if (temp < target) left ++;
            else {
                ret[0] = left + 1;
                ret[1] = right + 1;
                break;
            }
        }
        return ret;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 4, 6}, 8)));
        System.out.println(Arrays.toString(twoSum(new int[]{0,0,3,4}, 0)));
    }
}
