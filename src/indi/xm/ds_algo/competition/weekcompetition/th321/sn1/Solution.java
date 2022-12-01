package indi.xm.ds_algo.competition.weekcompetition.th321.sn1;


/**
 * t1 找出中枢整数
 */
public class Solution {

    // 思路：前缀和 + 遍历
    // 1、我们可以先求出 1 - i的前缀和数组
    // 2、我们遍历前缀和数组，假设中枢整数是i,那么我们要找到的是 pre[i] = pre[n] - pre[i-1]，如果满足这个的话，则i就是中枢整数
    // 3、找不到的话，直接返回-1
    public int pivotInteger(int n) {
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1] + i;
        }
        int ans = -1;
        for (int i = 1; i < n + 1; i++) {
            if (pre[n] - pre[i-1] == pre[i]) {
                ans = i;
                break;
            }
        }
        return ans;
    }


}
