package indi.xm.ds_algo.leetcode.sn.SN2000.s1769;

/**
 * @Author: albert.fang
 * @Description: 移动所有球到每个盒子所需的最小操作数
 * @Date: 2022/12/2 11:55
 */
public class Solution1 {

    // 纯模拟
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int sa = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (i == j) continue;
                if (boxes.charAt(j) == '1') sa += Math.abs(i - j);
            }
            ans[i] = sa;
        }
        return ans;
    }

}
