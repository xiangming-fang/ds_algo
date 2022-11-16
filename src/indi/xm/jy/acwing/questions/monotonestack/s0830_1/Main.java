package indi.xm.jy.acwing.questions.monotonestack.s0830_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.monotonestack.s0830_1
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 单调栈，左1大
 * @Date: 2022/11/16 13:17
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
        int[] ans = new int[n];

        int i = 0;
        while(i < n){
            while(tt > 0 && stk[tt] <= origin[i]) tt --;
            if(tt == 0) ans[i] = -1;
            else ans[i] = stk[tt];
            stk[++tt] = origin[i];
            i ++;
        }

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

//    5
//    3 4 2 7 5
//    -1 -1 4 -1 7
}
