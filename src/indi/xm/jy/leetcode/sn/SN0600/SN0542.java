package indi.xm.jy.leetcode.sn.SN0600;

import indi.xm.jy.leetcode.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

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

    private boolean[][] visited;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        visited = new boolean[m][n];


        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }

            }
        }
        int[][] ret = new int[m][n];
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            for (int[] ints : direction) {
                int newRow = ints[0] + row;
                int newCol = ints[1] + col;
                if (isTruePos(newRow,newCol) && !visited[newRow][newCol]){
                    ret[newRow][newCol] = ret[row][col] + 1;
                    queue.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return ret;
    }

    // true - 合法位置
    private boolean isTruePos(int row,int col){
        return row >= 0 && row < m && col >=0 && col < n;
    }

    @Test
    public void test(){
//        StringUtils.replaceArr("[[0,0,0],[0,1,0],[0,0,0]]");
        int[][] ints = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(updateMatrix(ints)));
    }
}
