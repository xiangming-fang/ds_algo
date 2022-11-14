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

    // 思路：双指针
    // 提示：最小公倍数算法 lcm = a * b / gcd(a,b) 其中gcd表示最大公约数
    // 1、以每个位置为子数组的开头位置记为指针i
    // 2、如果当前位置i都大于最大公约数 k了，那肯定是跳过当前位置，进行下次迭代
    // 3、在子数组中，以i位置为结尾的，记为指针j，同时记初始最最小公倍数为lcm = 1（因为任何数和1的最小公倍数都是其本身）
    // 4、求当前j位置和lcm的最小公倍数是多少，如果等于k，那么返回的答案+1
    // 5、如果小于k，那么j指针后移
    // 6、如果大于k，同样的，break掉以i为子数组开始的内嵌循环。
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
