package indi.xm.ds_algo.acwing.questions.diff.s0798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.diff.s0798
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 二维差分
 * @Date: 2022/10/27 22:15
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);
        int q = Integer.parseInt(f[2]);
        int[][] a = new int[n + 10][m + 10];
        // 差分数组
        int[][] b = new int[n + 10][m + 10];
        for (int i = 1; i <= n; i++) {
            String[] sec = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(sec[j-1]);
                insert(i,j,i,j,a[i][j],b);
            }
        }
        for (int i = 0; i < q; i++) {
            String[] opt = br.readLine().split(" ");
            int x1 = Integer.parseInt(opt[0]);
            int y1 = Integer.parseInt(opt[1]);
            int x2 = Integer.parseInt(opt[2]);
            int y2 = Integer.parseInt(opt[3]);
            int c = Integer.parseInt(opt[4]);
            insert(x1,y1,x2,y2,c,b);
        }
        // 用差分重新构造原数组a 并输出
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = a[i-1][j] + a[i][j-1] - a[i-1][j-1] + b[i][j];
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void insert(int x1, int y1, int x2, int y2, int c, int[][] b) {
        b[x1][y1] += c;
        b[x2+1][y2+1] += c;
        b[x1][y2+1] -= c;
        b[x2+1][y1] -= c;
    }
}
