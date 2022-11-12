package indi.xm.jy.competition.weekcompetition.th314;

public class SN0001 {

    public int hardestWorker(int n, int[][] logs) {
        int id = logs[0][0],time = logs[0][1];
        int t;
        for (int i = 1; i < logs.length; i++) {
            t = logs[i][1] - logs[i-1][1];
            if (t > time || (t == time && logs[i][0] < id)){
                time = t;
                id = logs[i][0];
            }
        }
        return id;
    }

}
