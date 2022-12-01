package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0517
 * @Author: albert.fang
 * @Description: 超级洗衣机
 * @Date: 2021/9/29 9:54
 */
public class SN0517 {
    public int findMinMoves(int[] machines) {
        // 如果洗衣机里的衣服总数量不能整除洗衣机个数，肯定不可以，返回-1
        int sum = Arrays.stream(machines).boxed().mapToInt(Integer::new).sum();
        if (sum % machines.length != 0) {
            return -1;
        }
        // 得到最初差值数组
        int avg = sum / machines.length;
        int[] diffValues = new int[machines.length];
        for (int i = 0; i < machines.length; i++) {
            diffValues[i] = machines[i] - avg;
        }
        // 变动差值数组
        int max = 0;
        for (int i = 0; i < diffValues.length - 1; i++) {
            max = Math.max(max,Math.abs(diffValues[i]));
            // 注意这里需要对下一个元素进行比较，形如：【-1，2，-1】
            max = Math.max(max,diffValues[i+1]);
            diffValues[i + 1] = diffValues[i] + diffValues[i + 1];
        }
        max = Math.max(max,Math.abs(diffValues[diffValues.length-1]));
        return max;
    }

    @Test
    public void test(){
//        System.out.println(findMinMoves(new int[]{1, 0, 5}));
//        System.out.println(findMinMoves(new int[]{0, 3, 0}));
        System.out.println(findMinMoves(new int[]{9,1,8,8,9}));
//        System.out.println(findMinMoves(new int[]{0, 2, 0}));
    }
}
