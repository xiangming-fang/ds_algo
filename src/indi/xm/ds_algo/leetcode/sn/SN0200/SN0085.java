package indi.xm.ds_algo.leetcode.sn.SN0200;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0085
 * @Author: albert.fang
 * @Description: 最大矩阵
 * @Date: 2022/10/27 16:47
 */
public class SN0085 {

    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[][] s = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + matrix[i-1][j-1] - '0';
            }
        }

        return res;
    }

}
