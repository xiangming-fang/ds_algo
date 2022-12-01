package indi.xm.ds_algo.acwing.questions.twopoint.s2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.twopoint.s2816
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 判断a是否是b的子序列
 * @Date: 2022/10/28 15:37
 */
public class Main {

    // 子序列：不要求是连续的，但是顺序是有要求的哦
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);
        int[] a = new int[n];
        int[] b = new int[m];
        String[] sec = br.readLine().split(" ");
        for (int i = 0; i < sec.length; i++) {
            a[i] = Integer.parseInt(sec[i]);
        }
        String[] th = br.readLine().split(" ");
        for (int i = 0; i < th.length; i++) {
            b[i] = Integer.parseInt(th[i]);
        }
        int i = 0,j  = 0;
        while (j < m){
            if (a[i] == b[j++]) i++;
            if (i == n) break;
        }
        if (i == n) System.out.println("Yes");
        else System.out.println("No");
    }
}
