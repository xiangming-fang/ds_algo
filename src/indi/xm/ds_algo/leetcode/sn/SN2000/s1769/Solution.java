package indi.xm.ds_algo.leetcode.sn.SN2000.s1769;

/**
 * @Author: albert.fang
 * @Description: 移动所有球到每个盒子所需的最小操作数
 * @Date: 2022/12/2 11:55
 */
public class Solution {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] pre = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (boxes.charAt(i) == '1') cnt++;
            }
            else {
                pre[i] = pre[i-1] + cnt;
                if (boxes.charAt(i) == '1') cnt++;
            }
        }
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1){
                if (boxes.charAt(i) == '1') cnt ++;
            }
            else {
                suffix[i] = suffix[i+1] + cnt;
                if (boxes.charAt(i) == '1') cnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] + suffix[i];
        }

        return ans;
    }

}
