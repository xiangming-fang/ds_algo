package indi.xm.ds_algo.leetcode.sn.SN2200;

import org.junit.Test;

import java.util.Arrays;

// 2022. 将一维数组转变成二维数组
public class SN2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {

        if (original.length !=  m * n) return new int[][]{};
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(original, i * n + i , ans[i], 0, n);
        }
        return ans;

    }

    @Test
    public void test(){
        System.out.println(Arrays.deepToString(construct2DArray(new int[]{1, 3, 3, 5}, 3, 1)));
    }
}
