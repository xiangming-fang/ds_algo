package indi.xm.ds_algo.leetcode.sn.SN0600;

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
public class SN0528_02 {

    private int[] pre;

    private int sum;

    // 前缀和 + 二分法
    public SN0528_02(int[] w) {
        sum = Arrays.stream(w).sum();
        pre = new int[w.length];
        // pre 数组的长度
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i-1] + w[i];
        }
    }

    public int pickIndex() {
        Random random = new Random();
        // 生成的随机数
        int randomNum = random.nextInt(sum) + 1;
//        randomNum = 1;
        int result = bs(randomNum, pre, 0, pre.length - 1);
        System.out.println(Arrays.toString(pre) + " " + randomNum + "  " + result);
        return result;
    }

    private int bs(int randomNum, int[] pre, int left, int right) {
        int mid  = left + (right - left)/2;

        if (left == right){
            return mid;
        }

        if (randomNum > pre[mid] && randomNum <= pre[mid + 1]){
            return mid + 1;
        }
        else if (mid == 0 && randomNum > 0 && randomNum <= pre[mid]){
            return mid;
        }
        else if (randomNum > pre[mid - 1] && randomNum <= pre[mid]){
            return mid;
        }

        if (randomNum > pre[mid]){
            left = mid;
            return bs(randomNum,pre,left,right);
        }
        else {
            right = mid;
            return bs(randomNum,pre,left,right);
        }
    }

    public static void main(String[] args) {
        SN0528_02 sn0528 = new SN0528_02(new int[]{3,14,1,7});
        for (int i = 0; i < 1000; i++) {
            sn0528.pickIndex();
        }
    }
}
