package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0566
 * @Author: albert.fang
 * @Description: 重塑矩阵
 * @Date: 2021/8/27 14:35
 */
public class SN0566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if (r * c != row * col){
            return mat;
        }
        int[][] result = new int[r][c];
        int n = 0,m = 0; // n 表示行 m表示列
        for (int[] ints : mat) {
            for (int j = 0; j < col; j++) {
                result[n][m] = ints[j];
                m++;
                if (m > c - 1) {
                    m = 0;
                    n++;
                }
            }
        }
        return result;
    }

    @Test
    public void test(){
    }
}
