package indi.xm.jy.competition.weekcompetition.th270;

public class SN0004 {

    public int[][] validArrangement(int[][] pairs) {
        int[][] res = new int[pairs.length][pairs[0].length];
        backtracking(res,pairs);
        return res;
    }

    private void backtracking(int[][] res, int[][] pairs) {

    }

}
