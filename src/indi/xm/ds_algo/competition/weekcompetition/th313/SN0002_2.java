package indi.xm.ds_algo.competition.weekcompetition.th313;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 2428.沙漏最大总和
 * @Date: 2022/10/21 16:26
 */
public class SN0002_2 {

    // 前缀和
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int pre = 0;
        int now = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (j == 0) {
                    pre = sandglassSum(grid,i,0);
                    max = Math.max(max,pre);
                    continue;
                }
                now = pre - grid[i][j-1] - grid[i + 1][j] - grid[i+2][j-1] + grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j+2];
                max = Math.max(max,now);
                pre = now;
            }
        }
        return max;
    }

    // 给定一个3*3的矩阵左上角坐标，算出沙漏的总和
    public int sandglassSum(int[][] grid,int r,int c){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == 1 && j == 0) || (i == 1 && j == 2) ){
                    continue;
                }
                sum += grid[r + i][c + j];
            }
        }
        return sum;
    }


}
