package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0528
 * @Author: albert.fang
 * @Description: 按权重随机选择
 * @Date: 2021/8/30 9:39
 */
public class SN0528 {

    private int[] w;

    private double[] right;

    public SN0528(int[] w) {
        this.w = w;
        int sum = Arrays.stream(w).sum();
        right = new double[w.length + 1];
        double curRight = 0;
        // right 数组的长度 比w多一个。
        right[0] = 0;
        for (int i = 1; i <= w.length; i++) {
            curRight = (double)w[i-1]/ sum;
            right[i] = right[i-1] + curRight;
        }
        right[w.length] = 1;
    }

    public int pickIndex() {
        int result = 0;
        int len = w.length;
        // 按权重获取下标
        Random random = new Random();
        int randomNum = random.nextInt(100) + 1;
        double probability = (double) randomNum / 100;
        for (int i = 1; i <= len; i++) {
            if (probability > right[i-1] && probability <= right[i]){
                result = i - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SN0528 sn0528 = new SN0528(new int[]{1,3,4,5});
        System.out.println(sn0528.pickIndex());
    }
}
