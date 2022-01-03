package indi.xm.jy.leetcode.sn.SN1000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0507
 * @Author: albert.fang
 * @Description: 507. 完美数
 * @Date: 2021/12/31 12:43
 */
public class SN0507 {

    public boolean checkPerfectNumber01(int num) {
        if (num < 0) return false;
        int mid = num >> 1;
        int ret = 0;
        for (int i = 1; i <= mid; i++) {
            if (num%i == 0) ret += i;
        }
        return ret == num;
    }

    public boolean checkPerfectNumber(int num) {
        int mid = (int)Math.sqrt(num);
        int ret = 0;
        for (int i = 1; i <= mid; i++) {
            if (num%i == 0) {
                if (num / i == i) ret += i;
                else ret += i + num/i;
            }
        }
        // 注意这里为什么是 2 * num
        // 因为在上面的循环中，当i == 1 的时候，另一个因子就是num，但是不应该包含num本身这个因子的，所以应该减去
        // 实际上等式应该是： ret - num == num
        // 简写成如下形式
        return ret == 2 * num;
    }

    @Test
    public void test(){
        System.out.println(checkPerfectNumber(28));
    }

}
