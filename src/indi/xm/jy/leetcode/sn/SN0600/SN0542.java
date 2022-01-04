package indi.xm.jy.leetcode.sn.SN0600;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0542
 * @Author: albert.fang
 * @Description: 01矩阵
 * @Date: 2021/9/2 16:34
 */
public class SN0542 {

    private int m,n;
    // 上右下左
    private int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] != 0)  dfs(mat,row,col);
            }
        }
        return mat;
    }

    // 找到row,col这个位置距离0最近的距离是多少
    private int dfs(int[][] mat, int row, int col) {
        if (!isTruePos(row,col)) return 0;
        if (mat[row][col] == 0) return 0;
        int ret = 1;
        for (int[] ans : direction) {
            int newRow = row + ans[0];
            int newCol = col + ans[1];
            ret += dfs(mat,newRow,newCol);
        }
        return ret;
    }

    // true - 合法位置
    private boolean isTruePos(int row,int col){
        return row >= 0 && row < m && col >=0 && col < n;
    }

}
