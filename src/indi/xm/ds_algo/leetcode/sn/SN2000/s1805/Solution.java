package indi.xm.ds_algo.leetcode.sn.SN2000.s1805;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * @Author: albert.fang
 * @Description: 字符串中不同的数字数目
 * @Date: 2022/12/6 13:48
 */
public class Solution {

    public int numDifferentIntegers(String word) {
        HashSet<BigInteger> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)){
                BigInteger x = new BigInteger("0");
                int j = i;
                while (j < word.length() && Character.isDigit(word.charAt(j))){
                    x = x.multiply(new BigInteger("10")).add(new BigInteger(String.valueOf(word.charAt(j) - '0')));
                    j ++;
                }
                set.add(x);
                i = j - 1;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("35985750011523523129774573439111590559325");
        System.out.println(bigInteger.toString());
    }

}
