package indi.xm.ds_algo.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0400
 * @Author: albert.fang
 * @Description: 第 N 位数字
 * @Date: 2021/11/30 10:02
 */
public class SN0400 {

    // 暴力超时 01
    public int findNthDigit01(int n) {
        int maxValue = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();
        // 前面的长度
        int pre = 0;
        // 第n个数字在哪个自然数上
        String natureNum = "";
        // res 有几个10000
        int count = 0;
        for (int i = 1; i < maxValue; i++) {
            if (res.length() >= 1000){
                count ++;
                res.delete(0,1000);
            }
            res.append(i);
            if (count * 1000 + res.length() >= n){
                natureNum = String.valueOf(i);
                pre = count * 1000 + res.length() - natureNum.length();
                break;
            }
        }
        int remains = n - pre;
        return natureNum.charAt(remains - 1) - '0';
    }



    @Test
    public void test(){
        System.out.println(findNthDigit01(11));
        System.out.println(findNthDigit01(3));
        System.out.println(findNthDigit01(2147483647));
    }
}
