package indi.xm.jy.competition.weekcompetition.th319;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0002 {

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0,lcm;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) continue;
            lcm = 1;
            for (int j = i; j < nums.length; j++) {
                lcm = lcm(lcm,nums[j]);
                if (lcm == k) ans ++;
                if (lcm > k) break;
            }
        }
        return ans;
    }


    public int gcd(int a,int b){
        return a % b == 0 ? b : gcd(b,a % b);
    }

    public int lcm(int a,int b){
        return a * b / gcd(a,b);
    }

    @Test
    public void test(){
        System.out.println(lcm(4,16));
    }
}
