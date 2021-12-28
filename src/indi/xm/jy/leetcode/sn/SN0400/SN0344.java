package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0344
 * @Author: albert.fang
 * @Description: 反转字符串
 * @Date: 2021/8/27 14:03
 */
public class SN0344 {
    public void reverseString01(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right){
            swap(s,left,right);
            left ++;
            right --;
        }
        System.out.println(s);
    }

    private void swap(char[] s,int l,int r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 1){
            return;
        }
        int left = 0,right = s.length - 1;
        while (left < right){
            swap(s,left++,right--);
        }
    }


    @Test
    public void test(){
        reverseString(new char[]{'d','r','o','w'});
    }
}
