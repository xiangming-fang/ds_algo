package indi.xm.ds_algo.competition.oddweekcompetition.th68;

public class SN0001 {

    public int mostWordsFound(String[] sentences) {
        int max = -1;
        for (String sentence : sentences) {
            int len = sentence.split(" ").length;
            max = Math.max(max,len);
        }
        return max;
    }

}
