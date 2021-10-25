package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * 搜索二维矩阵 II
 */
public class SN0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int colLength = matrix[0].length;
        for (int[] ints : matrix) {
            int l = 0, r = colLength - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] < target) {
                    l = mid + 1;
                } else { // matrix[i][mid] > target
                    r = mid - 1;
                }
            }
        }
        return false;
    }


    @Test
    public void test(){
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        System.out.println(searchMatrix(new int[][]{{-1},{-1}}, -2));
        System.out.println(searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}, 19));
        System.out.println(searchMatrix(new int[][]{{1,2,3,4,500},{6,7,8,9,501},{11,12,13,14,502},{16,17,18,19,503},{21,22,23,24,504}}, 502));

    }
}

