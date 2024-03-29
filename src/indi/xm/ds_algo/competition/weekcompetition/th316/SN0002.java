package indi.xm.ds_algo.competition.weekcompetition.th316;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 子数组最大公约数相等k的个数
 * @Date: 2022/10/21 16:26
 */
public class SN0002 {

    // 有点最大公约数的传递性味道
    // 比如：a b c d 的最大公约数是多少
    // 做法：a b 最大公约数 x；用 x 和 c 再取最大公约数 y; 用 y 再去和 d进行最大公约数求取 记为 z。
    // 此时 z 就是 a b c d 四个数的最大公约数
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 1、剪枝1：以i位置开始的子数组，若i位置数据不可以被k整除，则无需继续
            if (nums[i] % k != 0) {
                continue;
            }
            int g = 0;
            for (int j = i; j < nums.length; j++) {
                g = gcd(g,nums[j]);
                // 2、剪枝2：以i位置为子数组左边界，若最大公约数出现小于k的，再继续往后遍历是没有意义的。
                if (g < k){
                    break;
                }
                if (g == k){
                    res ++;
                }
            }
        }
        return res;
    }

    public int gcd(int a,int b){
        return a % b == 0 ? b : gcd(b , a % b);
    }

    @Test
    public void test(){
//        System.out.println(subarrayGCD(new int[]{3, 12, 9, 6}, 3));
        System.out.println(gcd(12,6));
        System.out.println(gcd(12,4));
        System.out.println(gcd(12,9));
        System.out.println(gcd(9,12));
        System.out.println(gcd(2,12));
    }
}
