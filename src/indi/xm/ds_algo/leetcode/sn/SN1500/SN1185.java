package indi.xm.ds_algo.leetcode.sn.SN1500;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1185
 * @Author: albert.fang
 * @Description: 一周中的第几天
 * @Date: 2022/1/3 15:44
 */
public class SN1185 {

    // 1971-1-1 礼拜五
    public String dayOfTheWeek(int day,int month,int year){
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int init = 4;
        int temp = 0;
        for (int i = 1971; i < year; i++) {
            if (isRun(i)) temp += 366;
            else temp += 365;
        }
        temp += dayOfYear(year,month,day);
        return week[(init + temp)%7];
    }

    private int dayOfYear(int year,int month,int day) {
        int[] yearArr = isPingOrRun(year);
        for (int i = 0; i < month - 1; i++) {
            day += yearArr[i];
        }
        return day;
    }

    private int[] isPingOrRun(int year){
        int[] ping = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] run = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isRun(year)){
            return run;
        }
        return ping;
    }

    private boolean isRun(int year){
        return  (year % 100 != 0 && year % 4 == 0) || year % 400 == 0;
    }

    @Test
    public void test(){
//        System.out.println(dayOfTheWeek(31, 8, 2019));
//        System.out.println(dayOfTheWeek(18, 1, 1971));
        System.out.println(dayOfTheWeek(15, 5, 2016));
    }

}
