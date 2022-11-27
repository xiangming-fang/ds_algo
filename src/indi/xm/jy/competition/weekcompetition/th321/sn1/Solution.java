package indi.xm.jy.competition.weekcompetition.th321.sn1;


/**
 * t1
 */
public class Solution {

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
