package indi.xm.jy.acwing.questions.monotonestack.s1574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.monotonestack.s1574
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 接雨水
 * @Date: 2022/11/17 11:44
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int N = 100010;
        int[] stk = new int[N];
        int tt = 0;
        int[] origin = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            origin[i] = Integer.parseInt(s[i]);
        }
        int[] lans = new int[n];
        int[] rans = new int[n];
        for (int i = 0; i < n; i++) {
            while (tt > 0 && origin[stk[tt]] <= origin[i]) tt--;
            if (tt == 0) lans[i] = -1;
            else lans[i] = stk[tt];
            stk[++tt] = i;
        }
        tt = 0;
        for (int i = n-1; i >= 0; i--) {
            while (tt > 0 && origin[stk[tt]] <= origin[i]) tt--;
            if (tt == 0) rans[i] = -1;
            else rans[i] = stk[tt];
            stk[++tt] = i;
        }

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            if (lans[i] == -1 || rans[i] == -1) continue;
            System.out.println("装水下标： " + i);
            int minHeight = Math.min(origin[lans[i]], origin[rans[i]]);
            for (int j = lans[i] + 1; j < rans[i]; j++) {
                ans += minHeight - origin[j];
            }
            i = rans[i] - 1;
        }
        System.out.println(ans + " ");
    }


}

// 10
// 0 10 4 6 5 0 9 8 10 2
// 28