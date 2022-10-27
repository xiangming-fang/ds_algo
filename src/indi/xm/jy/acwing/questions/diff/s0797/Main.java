package indi.xm.jy.acwing.questions.diff.s0797;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.diff.s0797
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 差分数组
 * @Date: 2022/10/27 18:37
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);
        int[] a = new int[n+1];
        String[] sec = br.readLine().split(" ");
        for (int i = 0; i < sec.length; i++) {
            a[i+1] = Integer.parseInt(sec[i]);
        }
        // 差分数组
        int[] diff = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            diff[i] = a[i] - a[i-1];
        }
        for (int i = 0; i < m; i++) {
            String[] op = br.readLine().split(" ");
            int l = Integer.parseInt(op[0]);
            int r = Integer.parseInt(op[1]);
            int c = Integer.parseInt(op[2]);
            // 只会影响 l位置和 r+1位置
            diff[l] += c;
            if (r + 1 <= n) diff[r+1] -= c;
        }
        for (int i = 1; i <= n; i++) {
            a[i] = a[i-1] + diff[i];
        }
        for (int i = 1; i <= a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
