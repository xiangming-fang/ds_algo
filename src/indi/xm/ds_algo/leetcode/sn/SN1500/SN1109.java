package indi.xm.ds_algo.leetcode.sn.SN1500;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1109
 * @Author: albert.fang
 * @Description: 航班预订统计
 * @Date: 2021/8/31 13:54
 */
public class SN1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            res[booking[0]-1] += booking[2];
            if (booking[1] - 1 < n - 1){
                res[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] + res[i];
        }
        return res;
    }


    // 暴力二，可以提交
    public int[] corpFlightBookings02(int[][] bookings, int n) {
        int[] res = new int[n];
        int idx;
        for (int[] booking : bookings) {
            idx = booking[0];
            while (idx <= booking[1]){
                res[idx - 1] += booking[2];
                idx ++;
            }
        }
        return res;
    }

    // 暴力一，超出时间限制
    public int[] corpFlightBookings01(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int[] booking : bookings) {
                if (booking[0] <= i && booking[1] >= i){
                    res[i-1] = res[i-1] + booking[2];
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 10}, {3, 5, 10}}, 5)));
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2,2,15}},2)));
    }

}
