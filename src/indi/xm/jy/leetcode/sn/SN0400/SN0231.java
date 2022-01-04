package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

// 2的幂
public class SN0231 {
    public boolean isPowerOfTwo01(int n) {
        if (n == 0){
            return false;
        }
        return (n & (n - 1)) == 0;
    }


    // 如果是2的幂次方的话，那么这个n的二进制肯定只有一个1
    public boolean isPowerOfTwo02(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    // n & (~n + 1) 提取 n 的最后一个1
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (~n + 1)) == n;
    }

    @Test
    public void test(){
        System.out.println(isPowerOfTwo(0));
    }
}
