package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0695
 * @Author: albert.fang
 * @Description: 岛屿的最大面积
 * @Date: 2021/9/1 16:19
 */
public class SN0695 {

    public int maxAreaOfIsland01(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    max = Math.max(dfs(grid,i,j,row,col),max);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c,int row,int col) {
        // 1、超出边界 或者 位置元素是 0
        if (r > row - 1 || r < 0 || c > col - 1 || c < 0 || grid[r][c] == 0){
            return 0;
        }
        // 注意这个count，每个点最大面积
        int count = 0;
        count += grid[r][c];
        // 清零，防止反复横跳
        grid[r][c] = 0;
        // 上下左右四个方向遍历
        count += dfs(grid,r - 1,c,row,col);
        count += dfs(grid,r + 1,c,row,col);
        count += dfs(grid,r,c - 1,row,col);
        count += dfs(grid,r,c + 1,row,col);
        return count;
    }

    /******************* 2022-01-04 **************************/

    private int m,n;
    private boolean[][] visited;
    // 上右下左
    private int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int res;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    res = Math.max(dfs(grid,row,col),res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (!isTruePos(row,col)) return 0;
        if (visited[row][col]) return 0;
        if (grid[row][col] == 0) return 0;
        visited[row][col] = true;
        int ans = 1;
        for (int[] dir : direction) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            ans += dfs(grid,newRow,newCol);
        }
        return ans;
    }

    // true - 合法位置
    private boolean isTruePos(int row,int col){
        return row >= 0 && row < m && col >=0 && col < n;
    }

    @Test
    public void test(){
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }
}
