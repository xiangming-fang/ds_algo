package indi.xm.jy.leetcode.sn.SN0200;

import indi.xm.jy.leetcode.sn.SN0600.SN0547;
import indi.xm.jy.leetcode.util.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0200
 * @Author: albert.fang
 * @Description: 200. 岛屿数量
 * @Date: 2021/12/20 12:04
 */
public class SN0200 {

    private boolean[][] visited;

    private int res = 0;

    // 四个方向，上右下左
    private int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == '1'){
                    res ++;
                    dfs(grid,row,col);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid,int row,int col){
        if (visited[row][col]){
            return;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isLegalPos(newRow,newCol) && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                dfs(grid,newRow,newCol);
            }
        }
    }

    // true 合法
    private boolean isLegalPos(int row,int col){
        return row >=0 && row < rows && col >= 0 && col < cols;
    }

    @Test
    public void test(){
        StringUtils.replaceArr("         [\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]");

        System.out.println(numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

}
