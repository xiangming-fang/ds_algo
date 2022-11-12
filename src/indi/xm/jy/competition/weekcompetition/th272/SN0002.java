package indi.xm.jy.competition.weekcompetition.th272;


public class SN0002 {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        int spaceIndex = 0;
        for (int i = 0; i < len; i++) {
            if (spaceIndex <= spaces.length - 1 && spaces[spaceIndex] == i) {
                res.append(" ");
                spaceIndex ++;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }

}
