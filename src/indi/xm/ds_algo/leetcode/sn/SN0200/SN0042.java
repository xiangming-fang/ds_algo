package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0042
 * @Author: albert.fang
 * @Description: 接雨水
 * @Date: 2021/9/30 10:17
 */
public class SN0042 {
    public int trap(int[] height) {
        int res = 0;
        // 第一根柱子和最后一根柱子肯定是装不了水的
        for (int i = 1; i < height.length - 1; i++) {

            // 1、找到左边比该位置高的最高的柱子下标 找不到则返回 -1
            int maxIndexInLeft = findMaxIndexInLeft(height, i);

            // 2、找到右边比该位置高的最高的柱子下标 找不到则返回 -1
            int maxIndexInRight = findMaxIndexInRight(height, i);

            if (maxIndexInLeft == -1 || maxIndexInRight == -1){
                continue;
            }
            int water = Math.min(height[maxIndexInLeft], height[maxIndexInRight]) - height[i];
            res += water;
        }
        return res;
    }

    private int findMaxIndexInLeft(int[] height,int index){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < index; i++) {
            if (height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        if (max > height[index]){
            return maxIndex;
        }
        return -1;
    }

    private int findMaxIndexInRight(int[] height,int index){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = index + 1; i < height.length; i++) {
            if (height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        if (max > height[index]){
            return maxIndex;
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap(new int[]{0,1,0,2,0,0,1,2,1}));
    }
}
