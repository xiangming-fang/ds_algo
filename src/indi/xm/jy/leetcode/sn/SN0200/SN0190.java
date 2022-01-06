package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.Random;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0190
 * @Author: albert.fang
 * @Description: 颠倒二进制位
 * @Date: 2022/1/5 9:43
 */
public class SN0190 {

    // 来自jdk的支配
    public int reverseBits01(int n) {
        return Integer.reverse(n);
    }

    // 出自方大鸣之手
    public int reverseBits(int n) {
        int bitIndex = 0;
        int res = 0;
        while (n != 0){
            // 得到n的二进制最低位
            int bit = (n & 1);
            // 相应的将最低位移动到最高位，并且和之前的结果或上
            res |= (bit << (31 - bitIndex ++));
            // 因为这个时候n的最低位已经得到了，下次就要去n的第二低位了，所以n无符号右移一位，让第二低位到最低位上
            // 无符号右移，高位统一补0
            n = n >>> 1;
        }
        return res;
    }

    private boolean detector(){
        Random rd = new Random();
        for (int i = 0; i < 1000000000; i++) {
            int randomNum = rd.nextInt(100000);
            if (reverseBits01(randomNum) != reverseBits(randomNum)) {
                throw new RuntimeException("颠倒二进制错误，颠倒出错的数字是：" + randomNum);
            }
        }
        return true;
    }

    @Test
    public void test(){
        if (detector()) {
            System.out.println("自己写的和jdk类库自带的一样");
        }
    }

}
