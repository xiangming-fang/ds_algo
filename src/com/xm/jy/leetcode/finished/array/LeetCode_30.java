package com.xm.jy.leetcode.finished.array;

/**
 * @author: albert.fang
 * @date: 2020/7/23 14:23
 * @description: 64. 最小路径和
 * @description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *               说明：每次只能向下或者向右移动一步。
 */
public class LeetCode_30 {

    /**
     * 动态规划做法
     * @param grid
     * @return
     */
    private static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0){
                    continue;
                }else if (i == 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else if (j == 0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else {
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] ants = new int[6][3];
        System.out.println(ants.length);
    }
}
