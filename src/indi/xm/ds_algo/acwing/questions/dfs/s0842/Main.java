package indi.xm.ds_algo.acwing.questions.dfs.s0842;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: albert.fang
 * @Description: 排列数字
 * @Date: 2022/12/19 17:08
 */
public class Main {
    static boolean[] flag;
    static StringBuilder sb;
    static int s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        s = n;
        flag = new boolean[n+1];
        sb = new StringBuilder();
        dfs();
    }
    public static void dfs(){
        if (sb.length() == s){
            for (int i = 0; i < sb.toString().length(); i++) {
                System.out.print(sb.charAt(i) + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= s; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            sb.append(i);
            dfs();
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
    }
}
