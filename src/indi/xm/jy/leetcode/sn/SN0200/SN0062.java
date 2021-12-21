package indi.xm.jy.leetcode.sn.SN0200;

// 不同路径
public class SN0062 {

    // 右、下
    int[][] nexts = new int[][]{{0,1},{1,0}};

    int res = 0;

    int m,n;


    // 回溯超时
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        int[][] matrix = new int[m][n];
        backtracking(matrix,0,0);
        return res;
    }

    private void backtracking(int[][] matrix, int row, int col) {
        // 走到目的地了
        if (row == m - 1 && col == n - 1){
            res ++;
            return;
        }

        for (int[] next : nexts) {
            int newRow = row + next[0];
            int newCol = col + next[1];
            if (isLegal(newRow,newCol)){
                backtracking(matrix,newRow,newCol);
            }
        }
    }

    // 判断机器人走向是否会越界
    // true 没有越界，false - 越界了
    private boolean isLegal(int row,int col){
        return row < m && col < n;
    }

    // 动态规划
    public int uniquePaths02(int m, int n) {
        int[][] matrix = new int[m][n];
        // 最后一行填上全部填上1
        for (int i = 0; i < n; i++) {
            matrix[m - 1][i] = 1;
        }
        // 最后一列填上全部填上1
        for (int i = 0; i < m; i++) {
            matrix[i][n - 1] = 1;
        }

        for (int row = m - 2; row >= 0 ; row--) {
            for (int col = n - 2; col >= 0; col--) {
                matrix[row][col] = matrix[row + 1][col] + matrix[row][col + 1];
            }
        }
        return matrix[0][0];
    }

}
