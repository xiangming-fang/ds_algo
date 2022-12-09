package indi.xm.ds_algo.leetcode.sn.SN2000.s1780_1;

import org.junit.Test;

/**
 * @Author: albert.fang
 * @Description: 判断一个数是否可以表示成3的幂
 * @Date: 2022/12/9 15:30
 */
public class Solution {

    // 因为数据量最多是1e7，所以3^x中的x取值范围是0-14，我们直接遍历就好。
    public boolean checkPowersOfThree(int n) {
        int cnt = 14;
        while (cnt >= 0 && n != 0){
            int x = (int)Math.pow(3,cnt);
            if ( x <= n) {
                n -= x;
                // 如果减多了，那么就得复原
                if (n < 0) n += x;
            }
            cnt--;
        }
        return n == 0;
    }

    @Test
    public void test(){
        System.out.println(checkPowersOfThree(6378022));
    }
}
