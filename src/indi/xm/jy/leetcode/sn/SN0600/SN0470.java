package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.Random;

/**
 *  用 Rand7() 实现 Rand10()
 */
public class SN0470 {
    public int rand10_01() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public int rand10() {
        while(true){
            int a =rand7()*10+rand7();
            if(a==11||a==12||a==13||a==14)
                return 1;
            if(a==15||a==16||a==17||a==21)
                return 2;
            if(a==22||a==23||a==24||a==25)
                return 3;
            if(a==26||a==27||a==31||a==32)
                return 4;
            if(a==33||a==34||a==35||a==36)
                return 5;
            if(a==37||a==41||a==42||a==43)
                return 6;
            if(a==44||a==45||a==46||a==47)
                return 7;
            if(a==51||a==52||a==53||a==54)
                return 8;
            if(a==55||a==56||a==57||a==61)
                return 9;
            if(a==62||a==63||a==64||a==65)
                return 10;
        }
    }

    private int rand7(){
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            int random = rand10();
            System.out.println(random);
        }
//        System.out.println("[4,6,5,5,5,4,5,5,6,6,6,6,5,5,6,4,6,4,6,6,5,6,7,7,7,6,5,5,6,6,5,4,5,7,6,4,3,6,5,5,5,5,6,6,5,5,5,5,5,6,5,6,6,4,6,5,7,6,6,4,6,4,5,5,5,4,4,6,5,5,4,5,5,4,7,7,5,5,5,6,6,5,7,7,5,5,7,6,6,6,6,6,6,4,5,4,4,5,6,5]".split(",").length);
//        System.out.println("[8,4,4,10,2,9,5,7,1,8,4,3,2,7,1,6,8,5,9,4,1,1,4,8,6,10,6,5,7,5,9,3,9,1,3,7,1,4,10,9,6,10,7,5,9,7,7,1,7,8,2,7,4,9,3,10,7,3,6,3,6,3,8,2,8,1,8,7,3,10,2,4,1,6,2,2,6,7,1,3,5,9,2,5,4,6,5,6,5,5,5,10,6,2,9,9,6,8,8,9]".split(",").length);
    }
}
