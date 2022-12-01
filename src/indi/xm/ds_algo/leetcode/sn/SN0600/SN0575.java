package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0575
 * @Author: albert.fang
 * @Description: 分糖果
 * @Date: 2021/11/1 17:49
 */
public class SN0575 {
    public int distributeCandies01(int[] candyType) {
        Arrays.sort(candyType);
        int type = 1;
        for (int i = 1; i < candyType.length; i++) {
            if (candyType[i] != candyType[i - 1]){
                type ++;
            }
        }
        int average = candyType.length / 2;
        return Math.min(average, type);
    }

    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        int average = candyType.length / 2;
        return Math.min(average, set.size());
    }

    @Test
    public void test(){
        System.out.println(distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println(distributeCandies(new int[]{1,1,2,3}));
    }
}
