package indi.xm.jy.leetcode.competition.weekcompetition.th316;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th316
 * @ClassName: SN001_1
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/26 19:34
 */
public class SN0001_1 {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event2[0].compareTo(event1[1]) > 0 || event1[0].compareTo(event2[1]) > 0);
    }
}
