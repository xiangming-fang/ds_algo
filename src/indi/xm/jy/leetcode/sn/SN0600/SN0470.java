package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Random;

/**
 *  用 Rand7() 实现 Rand10()
 */
public class SN0470 {
    public int rand10() {
        double count = 0;
        for (int i = 0; i < 10; i++) {
            count += rand7();
        }
        return (int)Math.ceil(count/7);
    }

    private int rand7(){
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            System.out.println(rand10());
        }
    }
}
