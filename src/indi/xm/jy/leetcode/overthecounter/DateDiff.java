package indi.xm.jy.leetcode.overthecounter;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.overthecounter
 * @ClassName: DateDiff
 * @Author: albert.fang
 * @Description: 两个时间差
 * @Date: 2022/3/30 10:47
 */
public class DateDiff {

    private void dataDiff(int[] start,int[] end){
        if (start.length != end.length){
            return;
        }
        if (start.length != 3){
            return;
        }
        if (compare(start,end) > 0){
            int[] temp = start;
            start = end;
            end = temp;
        }
        int startYear = start[0];
        int startMonth = start[1];
        int startDay = start[2];

        int endYear = end[0];
        int endMonth = end[1];
        int endDay = end[2];

        // 在同一年
        if (endYear == startYear){
            int[] months = isPingOrRun(startYear);
            int startTemp = startDay;
            for (int i = 0; i < startMonth - 1; i++) {
                startTemp += months[i];
            }
            int endTemp = endDay;
            for (int j = 0; j < endMonth - 1; j++) {
                endTemp += months[j];
            }
            System.out.println(endTemp - startTemp);
        }

        // 在紧接着两年
        if (startYear + 1 ==  endYear){
            int[] months = isPingOrRun(startYear);
            int temp;
            if (isRun(startYear)) {
                temp = 366;
            }else {
                temp = 365;
            }
            int startTemp = startDay;
            for (int i = 0; i < startMonth - 1; i++) {
                startTemp += months[i];
            }
            int days = temp - startTemp;

            int[] endMonths = isPingOrRun(endYear);
            int endTemp = endDay;
            for (int j = 0; j < endMonth - 1; j++) {
                endTemp += endMonths[j];
            }
            System.out.println(days + endTemp);
        }

        // 头尾大于2年
        if (endYear >= startYear + 2){
            int sum = 0;
            for (int i = startYear + 1; i < endYear; i++) {
                if (isRun(i)) {
                    sum += 366;
                }else {
                    sum += 365;
                }
            }
            int[] months = isPingOrRun(startYear);
            int temp;
            if (isRun(startYear)) {
                temp = 366;
            }else {
                temp = 365;
            }
            int startTemp = startDay;
            for (int i = 0; i < startMonth - 1; i++) {
                startTemp += months[i];
            }
            int days = temp - startTemp;

            int[] endMonths = isPingOrRun(endYear);
            int endTemp = endDay;
            for (int j = 0; j < endMonth - 1; j++) {
                endTemp += endMonths[j];
            }
            sum += days + endTemp;
            System.out.println(sum);
        }

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

    /**
     * 比较两个数组的打小
     *
     * @param arr
     * @param brr
     * @return int 如果 arr 大于 brr 返回 1，小于返回 - 1，等于返回 0
     * @author Albert.fang
     * @date 2022/3/30 11:35
     */
    private int compare(int[] arr,int [] brr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == brr[i]){
                continue;
            }
            if (arr[i] > brr[i]){
                return 1;
            }
            return -1;
        }
        return 0;
    }

    @Test
    public void test(){
        dataDiff(new int[]{2005,1,1},new int[]{2005,12,31});
        dataDiff(new int[]{2005,1,1},new int[]{2006,12,31});
        dataDiff(new int[]{2005,1,25},new int[]{2022,3,30});
        dataDiff(new int[]{1964,7,22},new int[]{2022,3,30});
        dataDiff(new int[]{2022,3,30},new int[]{1997,9,30});
    }

}
