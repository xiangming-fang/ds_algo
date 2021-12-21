package indi.xm.jy.leetcode.sn.SN0400;

import indi.xm.jy.leetcode.util.StringUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0329
 * @Author: albert.fang
 * @Description: 329. 矩阵中的最长递增路径
 * @Date: 2021/12/21 17:17
 */
public class SN0329 {

    int rows,cols;

    // 上右下左四个方向
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    // 记忆化
    int[][] mem;

    public int longestIncreasingPath(int[][] matrix) {

        rows = matrix.length;
        cols = matrix[0].length;
        mem = new int[rows][cols];

        int res = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mem[row][col] != 0){
                    res = Math.max(res,mem[row][col]);
                }else {
                    res = Math.max(backtracking(matrix,row,col),res);
                }
            }
        }
        return res;
    }

    // 定义，row,col这个位置最大增长序列是多少
    private int backtracking(int[][] matrix, int row, int col) {

        if (mem[row][col] != 0){
            return mem[row][col];
        }

        // 这个位置的最大增长序列长度是多少
        int ans = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isIllegalPos(newRow,newCol)  && matrix[newRow][newCol] > matrix[row][col]){
                ans = Math.max(ans,backtracking(matrix,newRow,newCol) + 1);
            }
        }
        mem[row][col] = ans;
        return mem[row][col];
    }


    private boolean isIllegalPos(int row,int col){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }


    @Test
    public void test(){
//        StringUtils.replaceArr("[[9,9,4],[6,6,8],[2,1,1]]");
//        StringUtils.replaceArr("[[3,4,5],[3,2,6],[2,2,1]]");
//        StringUtils.replaceArr("\n" +
//                "[[0,1,2,3,4,5,6,7,8,9],[19,18,17,16,15,14,13,12,11,10],[20,21,22,23,24,25,26,27,28,29],[39,38,37,36,35,34,33,32,31,30],[40,41,42,43,44,45,46,47,48,49],[59,58,57,56,55,54,53,52,51,50],[60,61,62,63,64,65,66,67,68,69],[79,78,77,76,75,74,73,72,71,70],[80,81,82,83,84,85,86,87,88,89],[99,98,97,96,95,94,93,92,91,90],[100,101,102,103,104,105,106,107,108,109],[119,118,117,116,115,114,113,112,111,110],[120,121,122,123,124,125,126,127,128,129],[139,138,137,136,135,134,133,132,131,130],[0,0,0,0,0,0,0,0,0,0]]");
//        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
//        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
//        int[][] matrix = {{1}};
        int[][] matrix =  {{0,1,2,3,4,5,6,7,8,9},
                {19,18,17,16,15,14,13,12,11,10},
                {20,21,22,23,24,25,26,27,28,29},
                {39,38,37,36,35,34,33,32,31,30},
                {40,41,42,43,44,45,46,47,48,49},
                {59,58,57,56,55,54,53,52,51,50},
                {60,61,62,63,64,65,66,67,68,69},
                {79,78,77,76,75,74,73,72,71,70},
                {80,81,82,83,84,85,86,87,88,89},
                {99,98,97,96,95,94,93,92,91,90},
                {100,101,102,103,104,105,106,107,108,109},
                {119,118,117,116,115,114,113,112,111,110},
                {120,121,122,123,124,125,126,127,128,129},
                {139,138,137,136,135,134,133,132,131,130},
                {0,0,0,0,0,0,0,0,0,0}};
        System.out.println(longestIncreasingPath(matrix));
    }


}
