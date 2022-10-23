package indi.xm.jy.leetcode.competition.weekcompetition.th316;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0001 {

    public boolean haveConflict(String[] event1, String[] event2) {
        int[] a = new int[2];
        int[] b = new int[2];
        a[0] = getMinute(event1[0]);
        a[1] = getMinute(event1[1]);
        b[0] = getMinute(event2[0]);
        b[1] = getMinute(event2[1]);
        return conflict(a,b);
    }

    public int getMinute(String time){
        String[] split = time.split(":");
        String hour = split[0];
        return Integer.parseInt(hour) * 60 + Integer.parseInt(split[1]);
    }

    public boolean conflict(int[] a,int[] b){
        if (a[0] < b[0]){
            return conflict(b,a);
        }
        if (b[0] >= a[0] && b[0] <= a[1]){
            return true;
        }
        return b[1] >= a[0] && b[1] <= a[1];
    }

}
