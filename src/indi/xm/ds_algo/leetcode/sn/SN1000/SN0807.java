package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0807
 * @Author: albert.fang
 * @Description: 807.保持城市天际线
 * @Date: 2021/12/13 10:17
 */
public class SN0807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 首先记下左右看最大值
        int[] maxLookFromLeft = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            maxLookFromLeft[i] = getMax(grid[i]);
        }
        // 其次记下前后看最大值
        int[] maxLookFromFront = getMaxFromCol(grid);
        int res = 0;
        // 前后看的值一个个和左右看的最大值比较
        for (int front = 0; front < maxLookFromFront.length; front++) {
            for (int left = 0; left < maxLookFromLeft.length; left++) {
                int pos = grid[left][front];
                if (pos != maxLookFromFront[front]){
                    // 前后、左右的最大值，谁小取谁，再减去当前位置的值
                    res += (Math.min(maxLookFromFront[front], maxLookFromLeft[left]) - pos);
                }
            }
        }
        return res;
    }

    private int getMax(int[] arr){
        int max = -1;
        for (int a : arr) {
            max = Math.max(max,a);
        }
        return max;
    }

    private int[] getMaxFromCol(int[][] grid){
        int[] maxLookFromFront = new int[grid[0].length];
        for (int col = 0; col < grid[0].length; col++) {
            int max = -1;
            for (int[] ints : grid) {
                max = Math.max(max, ints[col]);
            }
            maxLookFromFront[col] = max;
        }
        return maxLookFromFront;
    }

    @Test
    public void test(){
//        StringUtils.replaceChar("[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]",new char[]{'[',']'},new char[]{'{','}'});
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }

}
