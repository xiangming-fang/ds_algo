package indi.xm.jy.leetcode.competition.oddweekcompetition.th66;

import org.junit.Test;

// 5924. 网格图中机器人回家的最小代价
public class SN5924 {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int res = 0;

        // 如果大于 0 说明 目标在下
        int rowDela = homePos[0] - startPos[0];

        if (rowDela > 0){
            for (int i = 1; i <= rowDela; i++) {
                startPos[0] ++;
                res += rowCosts[startPos[0]];
            }
        }
        else if (rowDela < 0){
            rowDela = Math.abs(rowDela);
            // 目标在上方
            for (int i = 1; i <= rowDela; i++) {
                startPos[0] --;
                res += rowCosts[startPos[0]];
            }
        }

        // 如果大于 0 说明 目标在右边
        int colDela = homePos[1] - startPos[1];

        if (colDela > 0){
            for (int i = 1; i <= colDela; i++) {
                startPos[1] ++;
                res += colCosts[startPos[1]];
            }
        }
        else if (colDela < 0){
            colDela = Math.abs(colDela);
            // 目标在上方
            for (int i = 1; i <= colDela; i++) {
                startPos[1] --;
                res += colCosts[startPos[1]];
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}));
    }
}
