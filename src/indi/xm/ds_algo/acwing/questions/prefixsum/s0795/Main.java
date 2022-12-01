package indi.xm.ds_algo.acwing.questions.prefixsum.s0795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.prefixsum.s0795
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 前缀和
 * @Date: 2022/10/27 12:21
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int n = Integer.parseInt(first.split(" ")[0]);
        int m = Integer.parseInt(first.split(" ")[1]);
        int[] arr = new int[n+1];
        String[] second = br.readLine().split(" ");
        for (int i = 1; i <= second.length; i++) {
            arr[i] = Integer.parseInt(second[i-1]);
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i ] = sum[i-1] + arr[i];
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            System.out.println(sum[end] - sum[start - 1]);
        }
    }
}
