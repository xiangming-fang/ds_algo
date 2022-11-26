package indi.xm.jy.competition.oddweekcompetition.th92.sn2;

/**
 * t2
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
