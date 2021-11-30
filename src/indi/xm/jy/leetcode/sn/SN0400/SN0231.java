package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

// 2的幂
public class SN0231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    @Test
    public void test(){
        System.out.println(isPowerOfTwo(0));
    }
}
