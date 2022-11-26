package indi.xm.jy.competition.oddweekcompetition.th92.sn1;


/**
 * t1
 */
public class Solution {

    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if ((n & 1) == 0) return n >> 1;
        return n;
    }

}
