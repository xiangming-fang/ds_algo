package indi.xm.jy.acwing.questions.discretization.s0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.discretization.s0802
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 区间和
 * @Date: 2022/10/28 18:06
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int m = Integer.parseInt(f[1]);

        int[] discretization = new int[n];
        for (int i = 0; i < n; i++) {
            String[] sec = br.readLine().split(" ");
            int x = Integer.parseInt(sec[0]);
            int c = Integer.parseInt(sec[1]);
        }
    }
}
