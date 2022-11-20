package indi.xm.jy.competition.weekcompetition.th83.sn3;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.competition.weekcompetition.th83.sn3
 * @ClassName: Solution1
 * @Author: albert.fang
 * @Description: t3
 * @Date: 2022/11/17 20:49
 */
public class Main1 {

    // 思路：数论
    // 1: 假设 是以 a 为首项，并且长度为k的一连续数列和为n
    //    即：首项为a,尾项为a+k-1，公差为1的等差数列，该段数列和是：(a + a + k -1 ) * k/2
    // 2: 由于连续的和要等于n所以可以推出公式 => n = (a + a + k - 1) * k / 2
    // 3: 化简公式之后得：2n = (2a + k - 1) * k   （公式1）
    // 4: 根据第三步所得公式，我们可以得出 2a = 2n/k - k + 1，说明等式的右边是个偶数 （公式2）
    // 5: 根据第4步，再结合上 a 是首项，
    // 我们可以推出 => 2n/k -k +1 >= 2 => 2n/k >= 1+k => 2n >= k*(1+k)    （公式3）
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        // 此时的n就是2n
        n = n << 1;
        // 遍历k，k的终止条件看思路中的公式3
        for (int k = 1;k * (1+k) <= n;k++){
            // k肯定是n的约束，看公式1即可
            if (n % k != 0) continue;
            // 看公式2
            if (((n/k - k + 1) & 1) == 0) ans ++;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(consecutiveNumbersSum(5));
        System.out.println(consecutiveNumbersSum(9));
        System.out.println(consecutiveNumbersSum(15));
        System.out.println(consecutiveNumbersSum(1));
        System.out.println(consecutiveNumbersSum(933320757));
    }
}
