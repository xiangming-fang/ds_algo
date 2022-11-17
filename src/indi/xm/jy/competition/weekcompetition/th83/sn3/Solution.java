package indi.xm.jy.competition.weekcompetition.th83.sn3;

import org.junit.Test;

/**
 * t3
 */
public class Solution {

    // 双指针 tle 了
    public int consecutiveNumbersSum(int n) {
        if (n == 1) return 1;
        int l = 1,r = 1,sum = 0;
        int ans = 1;
        while (r <= (n+1)/2 || l <= (n+1)/2){
            if (sum == n) {
                ans ++;
                sum += r++;
            }
            else if (sum < n) sum += r++;
            else sum -= l++;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(consecutiveNumbersSum(5));
        System.out.println(consecutiveNumbersSum(9));
        System.out.println(consecutiveNumbersSum(15));
        System.out.println(consecutiveNumbersSum(1));
    }

}
