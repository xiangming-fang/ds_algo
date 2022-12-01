package indi.xm.ds_algo.acwing.questions.prefixsum.s0796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.prefixsum.s0796
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 子矩阵的和
 * @Date: 2022/10/27 15:45
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int q = Integer.parseInt(first[2]);
        // 原素组
        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                matrix[i+1][j+1] = Integer.parseInt(line[j]);
            }
        }
        // 二维前缀和数组
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
            }
        }
        for (int i = 0; i < q; i++) {
            String[] axis = br.readLine().split(" ");
            int x1 = Integer.parseInt(axis[0]);
            int y1 = Integer.parseInt(axis[1]);
            int x2 = Integer.parseInt(axis[2]);
            int y2 = Integer.parseInt(axis[3]);
            int ans = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
            System.out.println(ans);
        }
    }
}
