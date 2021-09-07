package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0011
 * @Author: albert.fang
 * @Description: 盛最多水的容器
 * @Date: 2021/9/5 12:32
 */
public class SN0011 {
    // 双指针
    // 双指针难点：指针移动的条件
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right){
            if (height[left] < height[right]){
                res = Math.max(res,height[left] * (right - left));
                left ++;
            }
            else {
                res = Math.max(res,height[right] * (right - left));
                right --;
            }
        }
        return res;
    }

    // 暴力 - 超时
    public int maxArea01(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                res = Math.max(res,Math.min(height[i],height[j]) * (j - i));
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{4,3,2,1,4}));
        System.out.println(maxArea(new int[]{1,2,1}));
        System.out.println(maxArea(new int[]{1,2}));
    }
}
