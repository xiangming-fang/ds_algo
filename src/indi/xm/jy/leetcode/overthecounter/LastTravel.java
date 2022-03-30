package indi.xm.jy.leetcode.overthecounter;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.overthecounter
 * @ClassName: LastTravel
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/2/28 21:39
 */
public class LastTravel {
        public long minimumTime(int[] time, int totalTrips) {
            Arrays.sort(time);

            long left = 1;
            long right = (long)time[0] * (long)totalTrips;
            long index = right;
            // 二分：左边的左边
            while (left <= right){
                long mid = left + ((right - left) >> 1);
                if (getBreakCondition(mid,time,totalTrips)){
                    index = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            return index;
        }

        // true 表示time是符合的
        private boolean getBreakCondition(long time,int[] original,int end){
            long ans = 0;
            for (int j : original) {
                ans += time / j;
            }
            return ans >= end;
        }

        @Test
        public void test(){
            int[] arr = new int[100000];
            Arrays.fill(arr,1);
            long ans = minimumTime(arr, 10000000);
            System.out.println(ans);
        }
}
