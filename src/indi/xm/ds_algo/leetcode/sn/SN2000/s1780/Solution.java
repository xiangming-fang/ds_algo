package indi.xm.ds_algo.leetcode.sn.SN2000.s1780;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Author: albert.fang
 * @Description: 判断一个数是否可以表示成三的幂的和
 * @Date: 2022/12/9 13:42
 * 思路：数学计算  + 模拟
 * 1. 计算第一个大于等于 n 的 3的指数即： 3^x >= n，求x的最小值
 * 2. 如果 3^x 恰好等于n，并且刚刚这个x并没有记录，那么说明找到了
 * 3. 没找到的话，记录 x-1，递归子问题 n - 3^(x-1)
 */
public class Solution {

    HashSet<Integer> set = new HashSet<>();

    public boolean checkPowersOfThree(int n) {
        return dfs(n);
    }

    public boolean dfs(int n) {
        // 剩余长度小于0，说明找不到了
        if (n < 0) return false;
        // 计算第一个大于等于 n 的 3的指数即： 3^x >= n，求x的最小值
        int ceil = (int)Math.ceil(Math.log(n) / Math.log(3));
        int more = (int)Math.pow(3,ceil);
        // 如果 3^x 恰好等于n，并且刚刚这个ceil并没有记录，那么说明找到了
        if (more == n && !set.contains(ceil)) return true;
        if (set.contains(ceil - 1)) return false;
        set.add(ceil - 1);
        int less = more / 3;
        int remain = n - less;
        return dfs(remain);
    }

    @Test
    public void test(){
        System.out.println(checkPowersOfThree(11));
    }

}
