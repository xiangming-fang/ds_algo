package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0397
 * @Author: albert.fang
 * @Description: 397. 整数替换
 * @Date: 2021/11/19 17:41
 */
public class SN0397 {

    // 记忆化
    Map<Integer,Integer> mem = new HashMap<>();

    public int integerReplacement(int n) {
        return dg(n);
    }

    // 找到 n 到 1 的最少次数
    private int dg(int n) {
        if ( n == 1){
            return 0;
        }
        if (!mem.containsKey(n)){
            if ((n & 1) == 0){
                mem.put(n,dg(n >> 1) + 1);
            }else {
                mem.put(n,Math.min(dg(n >> 1),dg((n >> 1) + 1)) + 2);
            }
        }
        return mem.get(n);
    }

    @Test
    public void test(){
        System.out.println(integerReplacement(2147483647));
    }
}
