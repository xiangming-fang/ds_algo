package indi.xm.jy.acwing.questions.twopoint.s0800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.twopoint.s0800
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 数组目标和
 * @Date: 2022/10/28 15:25
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);
        int x = Integer.parseInt(f[2]);
        int[] a = new int[n];
        String[] sec = br.readLine().split(" ");
        for (int i = 0; i < sec.length; i++) {
            a[i] = Integer.parseInt(sec[i]);
        }
        int[] b = new int[m];
        String[] th = br.readLine().split(" ");
        for (int i = 0; i < th.length; i++) {
            b[i] = Integer.parseInt(th[i]);
        }
        int i = 0,j = m-1;
        for (i = 0; i < n; i ++){
            while (j >=0 && a[i] + b[j] > x) j --;
            if (a[i] + b[j] == x) {
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}
