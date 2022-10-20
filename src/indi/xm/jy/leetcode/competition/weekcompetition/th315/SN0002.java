package indi.xm.jy.leetcode.competition.weekcompetition.th315;


import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class SN0002 {

    public int countDistinctIntegers(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,true);
            int reserveNum = reserveNum(num);
            hashMap.putIfAbsent(reserveNum, true);
        }
        return hashMap.size();
    }

    public int reserveNum(int num){
        int res = 0;
        while (num != 0){
            res = res * 10 + num % 10;
            num = num / 10;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(countDistinctIntegers(new int[]{1, 13, 10, 12, 31,100,1000,10000,1}));
    }

}
