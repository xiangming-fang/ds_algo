package indi.xm.ds_algo.leetcode.sn.SN0400.sn0231_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: albert.fang
 * @Description: 2的幂
 * @Date: 2022/12/9 16:17
 */
public class Solution {

    // 短除法，将10进制转成2进制
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int ans = 0;
        while (n != 0){
            if ((n%2 & 1) == 1) ans ++;
            n /= 2;
        }
        return ans == 1;
    }

    public List<Integer> convertRadix(int n, int m){
        List<Integer> ans = new ArrayList<>();
        while (n != 0){
            ans.add(n%m);
            n /= m;
        }
        Collections.reverse(ans);
        return ans;
    }

    @Test
    public void test(){
        System.out.println(convertRadix(90, 2));
    }
}
