package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0375
 * @Author: albert.fang
 * @Description: 猜数字大小 II
 * @Date: 2021/11/12 15:22
 */
public class SN0375 {
    public int getMoneyAmount(int n) {
        int res = 0;
        // 左闭右闭
        int left = 1,right = n;
        int mid = 0;
        while (left != right || left + 1 != right){
            mid = left +(right - left)/2;
            res += mid;
            left = mid + 1;
        }
        return res;
    }

    @Test
    public void test(){
//        System.out.println(getMoneyAmount(1));
//        System.out.println(getMoneyAmount(10));
        int ans = 0x3f3f3f3f;
        System.out.println(ans);
    }
}
