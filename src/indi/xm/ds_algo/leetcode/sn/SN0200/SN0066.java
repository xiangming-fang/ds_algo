package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.Arrays;

/**
 * 加一
 */
public class SN0066 {
    public int[] plusOne(int[] digits) {
        // 考虑是否全为9,true - 是
        boolean flag = true;
        for (int digit : digits) {
            if (digit != 9){
                flag = false;
                break;
            }
        }
        if (flag){
            int[] res = new int[digits.length + 1];
            for (int i = 0; i < res.length; i++) {
                if (i == 0){
                    res[i] = 1;
                }else {
                    res[i] = 0;
                }
            }
            return res;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] >= 10){
                digits[i] = 0;
            }
            else {
                break;
            }
        }
        return digits;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
    }
}
