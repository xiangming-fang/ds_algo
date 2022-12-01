package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

/**
 * 回文数
 */
public class SN0009 {
    // 双指针
    public boolean isPalindrome(int x) {
        String s = x + "";
        if (s.length() < 2) {
            return true;
        }
        char[] ca = s.toCharArray();
        int left = 0;
        int right = ca.length - 1;
        while (left <= right){
            if (ca[left] != ca[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome(234565432));
        System.out.println(isPalindrome(1234565432));
    }
}
