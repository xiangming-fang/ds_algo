package indi.xm.ds_algo.leetcode.sn.SN2000.s1812;

/**
 * @Author: albert.fang
 * @Description: 判断国际象棋的颜色
 * @Date: 2022/12/8 18:34
 */
public class Solution {

    public boolean squareIsWhite(String coordinates) {
        int a = coordinates.charAt(0) - 'a' + 1;
        return !(((a+coordinates.charAt(1) - '0') & 1) == 0);
    }


}
