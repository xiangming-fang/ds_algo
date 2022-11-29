package indi.xm.jy.competition.oddweekcompetition.th92.sn4;

import java.util.Arrays;

/**
 * @Author: albert.fang
 * @Description: 统计回文子序列个数
 * @Date: 2022/11/29 14:44
 */
public class Solution1 {

    // 和方法一类似，这里只不过给每个字符串位置都维护两个数组：前缀组合数组pre、后缀组合数组suf
    public int countPalindromes(String s) {
        int mod = (int)1e9 + 7;
        int n = s.length();
        int[] count = new int[10];
        int[][] comboCount = new int[10][10];
        int[][][] suf = new int[n+1][10][10];
        int[][][] pre = new int[n+1][10][10];
        int d;

        // 1、维护后缀数组
        for (int i = n - 1; i >= 0; i--) {
            d = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    suf[i][j][k] = suf[i+1][j][k];
                }
            }
            for (int k = 0; k < 10; k++) {
                suf[i][d][k] += count[k];
            }
            count[d]++;
        }
        Arrays.fill(count,0);

        // 2、维护前缀数组
        for (int i = 0; i < n; i++) {
            d = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    pre[i+1][j][k] = pre[i][j][k];
                }
            }
            for (int k = 0; k < 10; k++) {
                pre[i+1][d][k] += count[k];
            }
            count[d]++;
        }

        // 3、根据前缀、后缀数组得到每个位置的答案，并进行累加答案
        long ans = 0;
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans += (long) pre[i-1][j][k] * suf[i][j][k];
                }
            }
        }
        return (int)(ans % mod);
    }
}
