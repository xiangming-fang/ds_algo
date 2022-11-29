package indi.xm.jy.competition.oddweekcompetition.th92.sn2;

/**
 * t2 行和列中一和零的差值
 * 算法原型：模拟
 * 思路：
 * 1、用四个数组：rowOneNum,colOneNum,rowZeroNum,colZeroNum;
 * 分别存储当前行1的个数、当前列1的个数、当前行0的个数、当前列0的个数
 * 2、遍历元素组的每个位置，组成目标数组
 *
 */
public class Solution {

    int m,n;
    int[] rowOneNum,colOneNum,rowZeroNum,colZeroNum;

    public int[][] onesMinusZeros(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        rowOneNum = new int[m];
        rowZeroNum = new int[m];
        colOneNum = new int[n];
        colZeroNum = new int[n];
        for (int i = 0; i < m; i++) {
            int oneNums = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) oneNums++;
            }
            rowOneNum[i] = oneNums;
            rowZeroNum[i] = n - oneNums;
        }
        for (int i = 0; i < n; i++) {
            int oneNums = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) oneNums++;
            }
            colOneNum[i] = oneNums;
            colZeroNum[i] = m - oneNums;
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = rowOneNum[i] + colOneNum[j] - rowZeroNum[i] - colZeroNum[j];
            }
        }
        return ans;
    }


}
