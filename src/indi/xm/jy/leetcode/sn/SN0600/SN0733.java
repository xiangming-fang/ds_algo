package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0733
 * @Author: albert.fang
 * @Description: 图像渲染
 * @Date: 2021/9/1 15:29
 */
public class SN0733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int oldColor = image[sr][sc];
        boolean[][] visited = new boolean[row][col];
        dfs(image,sr,sc,row,col,oldColor,newColor,visited);
        return image;
    }

    /**
     *
     * @param image 二维数组
     * @param r 上下左右以及当前的横坐标
     * @param c 上下左右以及当前的纵坐标
     * @param row 二维数组总共有几行
     * @param col 二维数组总共有几列
     * @param oldColor 给定的初始旧颜色
     * @param newColor 要修改的新颜色
     */
    private void dfs(int[][] image,int r, int c, int row, int col, int oldColor, int newColor,boolean[][] visited) {
        // 1、超出边界终止
        if (r > row - 1 || r < 0 || c > col - 1 || c < 0){
            return;
        }
        // 2、当前位置颜色值和旧颜色值不同 或者改点位置已经访问过了 ，终止
        if (image[r][c] != oldColor || visited[r][c]){
            return;
        }
        image[r][c] = newColor;
        visited[r][c] = true;
        // 上下左右四个方向遍历
        dfs(image,r - 1,c,row,col,oldColor,newColor,visited);
        dfs(image,r + 1,c,row,col,oldColor,newColor,visited);
        dfs(image,r,c - 1,row,col,oldColor,newColor,visited);
        dfs(image,r,c + 1,row,col,oldColor,newColor,visited);
    }

    @Test
    public void test(){
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 1)));
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0,0,0}, {0,1,1}}, 1, 1, 1)));
    }
}
