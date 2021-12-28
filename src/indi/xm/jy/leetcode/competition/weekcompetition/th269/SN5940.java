package indi.xm.jy.leetcode.competition.weekcompetition.th269;

import org.junit.Test;

import java.io.IOException;

// 从数组中移除最大值和最小值
public class SN5940 {

    public int minimumDeletions(int[] nums) {
        int maxIndex = -1,max = Integer.MIN_VALUE;
        int minIndex = 1,min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }
        int pre = Math.min(maxIndex, minIndex);
        int after = Math.max(maxIndex, minIndex);
        int mid = Math.abs( maxIndex - minIndex);
        int last = nums.length - after;
        int f = pre + 1;
        return getMin(f + mid,last + mid,f+last);
    }

    private int getMin(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }

    @Test
    public void test() throws IOException {
        System.out.println(minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
    }
}
