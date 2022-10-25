package indi.xm.jy.leetcode.competition.weekcompetition.th316;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 使数组相等的最小开销
 * @Date: 2022/10/21 16:26
 */
public class SN0003 {

    // 疑问：
    // 1、为什么可以将每个nums[i] 看成出现了 cost[i] 次？
    // 2、为什么基值x肯定出现在nums数组里？
    public long minCost(int[] nums, int[] cost) {
        int[][] ints = new int[nums.length][2];
        long res = 0;
        long len = nums.length;
        for (int i = 0; i < len; i++) {
            ints[i][0] = nums[i];
            ints[i][1] = cost[i];
        }
        Arrays.sort(ints, Comparator.comparingInt(a -> a[0]));
        long total = 0;
        for (int j : cost) {
            total += j;
        }
        long midIndex = 0;
        long mid = 0;
        for (int[] anInt : ints) {
            midIndex += anInt[1];
            if (midIndex >= total / 2) {
                mid = anInt[0];
                break;
            }
        }
        for (int[] anInt : ints) {
            res += Math.abs(anInt[0] - mid) * (long)anInt[1];
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minCost(new int[]{1, 3, 5, 2}, new int[]{2, 3, 1, 14}));
    }



}
