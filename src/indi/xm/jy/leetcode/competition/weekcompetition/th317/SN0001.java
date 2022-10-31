package indi.xm.jy.leetcode.competition.weekcompetition.th317;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0001 {

    public int averageValue(int[] nums) {
        int res = 0,cnt = 0;
        for (int num : nums) {
            if ((num & 1) == 0 && num % 3 == 0) {
                res += num;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : res / cnt;
    }

    @Test
    public void test(){
        System.out.println(averageValue(new int[]{4, 4, 9, 10}));
    }
}
