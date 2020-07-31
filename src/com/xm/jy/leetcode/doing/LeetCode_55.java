package com.xm.jy.leetcode.doing;

/**
 * @author: albert.fang
 * @date: 2020/7/28 10:09
 * @description: 29. 两数相除
 * @description: 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。忽略小数部分
 *
 */
public class LeetCode_55 {
    /**
     * 换句话说就是用+ 、-实现除法的功能。没有用移位操作，数据量太大，所以报超时了
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide1(int dividend, int divisor) {
        if (divisor == 0){
            return 0;
        }
        int count = 0;
        if (dividend > 0 && divisor > 0){
            while (dividend >= divisor){
                dividend -=divisor;
                if (count == Integer.MAX_VALUE){
                    count = Integer.MAX_VALUE;
                    break;
                }
                count ++;
            }
        }
        else if (dividend < 0 && divisor < 0){
            while (dividend <= divisor){
                dividend -=divisor;
                if (count == Integer.MAX_VALUE){
                    count = Integer.MAX_VALUE;
                    break;
                }
                count ++;
            }
        }
        else {
            if (divisor > 0){
                while (dividend <= -divisor){
                    dividend +=divisor;
                    count --;
                }
            }
            if (dividend > 0){
                while (-dividend <= divisor){
                    dividend +=divisor;
                    count --;
                }
            }

        }
        return count;
    }


    /**
     * 用移位实现功能
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide2(int dividend, int divisor){
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(divide1(-2147483648, -1));
    }
}
