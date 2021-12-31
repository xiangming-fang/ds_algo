package indi.xm.jy.leetcode.sn.SN1000;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// 846. 一手顺子
public class SN0846 {

        public boolean isNStraightHand(int[] hand, int groupSize) {

            if (hand.length % groupSize != 0) {
                return false;
            }
            Arrays.sort(hand);
            HashSet<Integer> set = new HashSet<>();
            int grpTh = hand.length / groupSize;
            for (int i = 0; i < grpTh; i++) {
                for (int j = 0; j < groupSize; j++) {
                    if (set.contains(hand[i * groupSize + j])) return false;
                    else set.add(hand[i * groupSize + j]);
                }
                set.clear();
            }
            return true;
        }

        @Test
        public void test(){
            int[] ans = {1, 2, 3, 6, 2, 3, 4, 7, 8};
            System.out.println(isNStraightHand(ans, 3));
        }
}
