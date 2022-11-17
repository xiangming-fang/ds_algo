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

    // 思路：以每个位置的元素为盛水容器的底部位置
    // 1、求出每个位置的左1大和右1大的位置，分别用数组lans、rans存储，如果某个位置不存在左1大或者右1大，那么填充-1
    // 2、定义origin数组为柱子的高度数组、当前位置为i，当前位置的为底的盛水左边界高度是 lh = origin[lans[i]]、rh = origin[rans[i]]
    // 3、取lh、rh的小值，记为minH，那么以当前位置高度为底的可以盛水是：左右边界距离 * (minH - 当前位置高度) ==> (rh - lh - 1) * (minH - origin[i])
    //    1 - 3步是主要思想
    // 4、因为在同一个盛水区间里，可能存在高度相同，并且左右边界也相同的情况，这样就会重复计算盛水空间，所以我们需要这样一个标识
    // 即 高度 ==> lh、rh 唯一，如果存在，则跳过当前迭代位置
    // 举个例子说明第4步的必要性，如果只考虑1-3步骤，那么在以下 i = 4和i = 6的时候（i从0开始），会出现重复计算的情景，使得结果多了3个盛水区间。
    // 0 1 0 2 1 0 1 3 2 1 2 1
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
        // 确保以这个height为底的盛水区间不被重复计算
        int[][] exist = new int[10010][2];
        for (int i = 0; i < n; i ++) {
            if (lans[i] == -1 || rans[i] == -1) continue;
            if (exist[origin[i]][0] == lans[i] && exist[origin[i]][1] == rans[i]) continue;
            exist[origin[i]][0] = lans[i];
            exist[origin[i]][1] = rans[i];
            int minHeight = Math.min(origin[lans[i]], origin[rans[i]]);
            ans += (minHeight - origin[i]) * (rans[i] - lans[i] - 1);
        }
        System.out.println(ans + " ");
    }


}

// 10
// 0 10 4 6 5 0 9 8 10 2
// 28

// 12
// 0 1 0 2 1 0 1 3 2 1 2 1
// 6