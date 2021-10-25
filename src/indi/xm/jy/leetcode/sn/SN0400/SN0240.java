package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * 搜索二维矩阵 II
 */
public class SN0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return dfs(matrix, target, 0, 0);
    }

    private boolean dfs(int[][] matrix, int target,int row,int col){
        if (row >= matrix.length || col >= matrix[0].length){
            return false;
        }
        if (matrix[row][col] == target){
            return true;
        }
        else  if (col + 1 >= matrix[0].length || (col + 1 < matrix[0].length && matrix[row][col + 1] > target)){
            return dfs(matrix,target,row + 1,col);
        }
        else{
            return dfs(matrix,target,row,col + 1);
        }
    }

    @Test
    public void test(){
//        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
//        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        System.out.println(searchMatrix(new int[][]{{-1},{-1}}, -2));
    }
}

