package indi.xm.ds_algo.acwing.questions.kmp.s0831_1;

import java.io.*;

/**
 * @Author: albert.fang
 * @Description: KMP 字符串
 * @Date: 2022/12/1 15:08
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String p = " " + br.readLine();
        int m = Integer.parseInt(br.readLine());
        String s = " " + br.readLine();
        int[] next = new int[n + 1];
        for(int i = 2,j = 0;i <= n;i ++){
            while (j != 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (p.charAt(i) == p.charAt(j+1)) j++;
            next[i] = j;
        }
        for (int i = 1,j = 0; i <= m; i++){
            while (j != 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == p.charAt(j+1)) j++;
            if (j == n){
                j = next[j];
                bw.write(i-n + " ");
            }
        }
        bw.flush();
    }
}
