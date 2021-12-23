package indi.xm.jy.leetcode.sn.SN1500;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1154
 * @Author: albert.fang
 * @Description: 1154. 一年中的第几天
 * @Date: 2021/12/21 9:36
 */
public class SN1154 {

    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int[] yearArr = isPingOrRun(year);
        for (int i = 0; i < month - 1; i++) {
            day += yearArr[i];
        }
        return day;
    }

    private int[] isPingOrRun(int year){
        int[] ping = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] run = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return run;
        }
        return ping;
    }

    @Test
    public void test(){
//        System.out.println(dayOfYear("2021-12-22") - dayOfYear("2021-10-05") + 1);
        System.out.println(1e5 + 10);
    }
}
