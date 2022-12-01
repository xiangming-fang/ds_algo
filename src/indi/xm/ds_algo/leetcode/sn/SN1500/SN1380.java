package indi.xm.ds_algo.leetcode.sn.SN1500;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1380
 * @Author: albert.fang
 * @Description: 1380. 矩阵中的幸运数
 * @Date: 2022/2/15 22:32
 */
public class SN1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 每行中最小的元素下标
        int[] rowMinCols = new int[rows];
        for (int i = 0; i < rows; i++) {
            rowMinCols[i] = getMin(matrix[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowMinCols.length; i++) {
            int ans = matrix[i][rowMinCols[i]];
            boolean flag = true;
            for (int[] ints : matrix) {
                if (ans < ints[rowMinCols[i]]) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(ans);
        }
        return res;
    }

    private int getMin(int[] arr){
        int ret = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ret) {
                minIndex = i;
                ret = arr[i];
            }
        }
        return minIndex;
    }

}
