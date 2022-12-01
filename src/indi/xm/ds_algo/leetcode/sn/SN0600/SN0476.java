package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0476
 * @Author: albert.fang
 * @Description: 数字的补数
 * @Date: 2021/10/18 9:33
 */
public class SN0476 {
    public int findComplement01(int num) {
        long a = 1;
        for (int i = 0; i <= 31; i++) {
            if (num <= a - 1){
                break;
            }
            a = a << 1;
        }
        return (int) (a - num - 1);
    }

    public int findComplement(int num) {
        // 为什么sum 也要等于1？
        // 答：01 要变成 11 左移一位，然后加1，让低位也成1
        int sum = 1;
        int a = 1;
        while (num > sum){
            a <<= 1;
            sum += a;
        }
        return sum - num;
    }

    @Test
    public void test(){
        System.out.println(findComplement(1));
        System.out.println(findComplement(2));
        System.out.println(findComplement(5));
    }
}
