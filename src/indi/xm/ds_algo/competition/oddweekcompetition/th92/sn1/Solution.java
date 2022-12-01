package indi.xm.ds_algo.competition.oddweekcompetition.th92.sn1;


/**
 * t1 分割圆的最少切割次数
 */
public class Solution {

    // 算法原型：数学
    // 思路：
    // 1、当要分隔成奇数块，那肯定是要切几刀
    // 2、偶数块的话，是块数/2
    // 3、分成一块的话，特殊考虑,切 0刀
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if ((n & 1) == 0) return n >> 1;
        return n;
    }

}
