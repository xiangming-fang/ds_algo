package indi.xm.jy.competition.weekcompetition.th273;

public class SN0001 {

    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        String s = String.valueOf(num);
        return !(s.charAt(s.length() - 1) == '0');
    }

}
