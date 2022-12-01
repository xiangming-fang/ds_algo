package indi.xm.ds_algo.acwing.questions.monotonestack.s0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.monotonestack.s0131
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 直方图中最大的矩形
 * @Date: 2022/11/16 15:37
 */
public class Main {

    // 思路：
    // 1、算出给定直方图的左一小（左边第一个小于当前位置的位置）得到数组lans，这里下标记为lindex;
    // 2、算出给定直方图的右一小（右边第一个小于当前位置的位置）得到数组rans，这里下标记为rindex;
    // 3、每个位置值(记为x)的最大面积是：x * (rindex - lindex - 1)
    // 4、迭代每个位置，找到最大面积
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 100010;
        int[] stk = new int[N];
        while (true){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            if ( n == 0) break;
            int[] origin = new int[n];
            int[] lans = new int[n];
            int[] rans = new int[n];
            int tt = 0;
            for (int i = 1; i <= n; i++) {
                origin[i-1] = Integer.parseInt(s[i]);
            }
            for (int i = 0; i < n; i++) {
                while (tt > 0 && origin[stk[tt]] >= origin[i]) tt--;
                if (tt==0) lans[i] = -1;
                else lans[i] = stk[tt];
                stk[++tt] = i;
            }
            tt = 0;
            for (int i = n - 1; i >= 0; i --){
                while (tt > 0 && origin[stk[tt]] >= origin[i]) tt--;
                if (tt == 0) rans[i] = n;
                else rans[i] = stk[tt];
                stk[++tt] = i;
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans,(long)origin[i] * (rans[i] - lans[i] - 1));
            }
            System.out.println(ans);
        }
    }
}

// 9 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 999999999 1000000000 1000000000
