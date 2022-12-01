package indi.xm.ds_algo.acwing.questions.sph.s0841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.sph.s0841
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 字符串hash
 * @Date: 2022/11/24 8:25
 */
public class Main {

    // 字符串最大长度是100000，多给个10
    int N = 100010;
    int P = 131;
    long[] h = new long[N];
    long[] p = new long[N];

    public long get(int l,int r){
        return h[r] - h[l-1] * p[r-l+1];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String str = br.readLine();
        main.p[0] = 1;
        for (int i = 0; i < n; i++) {
            main.h[i+1] = main.h[i] * main.P + str.charAt(i);
            main.p[i+1] = main.p[i] * main.P;
        }
        while (m -- > 0){
            String[] region = br.readLine().split(" ");
            int l1 = Integer.parseInt(region[0]);
            int r1 = Integer.parseInt(region[1]);
            int l2 = Integer.parseInt(region[2]);
            int r2 = Integer.parseInt(region[3]);
            if (main.get(l1,r1) == main.get(l2,r2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }

}
