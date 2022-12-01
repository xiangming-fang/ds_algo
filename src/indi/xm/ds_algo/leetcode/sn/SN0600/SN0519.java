package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0519
 * @Author: albert.fang
 * @Description: 随机翻转矩阵
 * @Date: 2021/11/27 13:05
 */
public class SN0519 {

    private class Solution {

        private int[][] matrix;

        private Random random = new Random();

        // 存放二维矩阵每个位置的坐标值
        List<String> positionList = new ArrayList<>();

        public Solution(int m, int n) {
            matrix = new int[m][n];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    // 放入二维矩阵每个位置的坐标值
                    positionList.add(i + "-" + j);
                }
            }
        }

        // 这道题关键是实现这个 flip 方法
        // 实现 flip 方法的关键又是如何在 二维平面上等概率的随机选取一个位置 并且这个选取的范围会随着选取次数逐渐变小
        public int[] flip() {
            int[] position = new int[2];
            int len = positionList.size();
            // 生成还剩余的坐标个数
            int randNum = random.nextInt(len);
            String removePosition = positionList.remove(randNum);
            String[] split = removePosition.split("-");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            // 更改matrix里的值
            matrix[row][col] = 1;
            // 封装返回坐标
            position[0] = row;
            position[1] = col;
            return position;
        }

        public void reset() {
            for (int[] ans : matrix) {
                // jdk 底层方法，将一维数组 ans 里的所有元素值 替换成 0
                Arrays.fill(ans, 0);
            }
            positionList.clear();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    // 放入二维矩阵每个位置的坐标值
                    positionList.add(i + "-" + j);
                }
            }

        }
    }

    @Test
    public void test(){
        Solution solution = new Solution(4, 17);
        for (int i = 0; i < 68; i++) {
            System.out.println(Arrays.toString(solution.flip()));
        }
    }
}
