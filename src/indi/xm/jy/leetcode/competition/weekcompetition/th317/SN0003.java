package indi.xm.jy.leetcode.competition.weekcompetition.th317;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0003 {


    public long makeIntegerBeautiful(long n, int target) {
        long res = 0;
        if (getSumByBit(n) <= target) return 0;
        List<Integer> numBit = getNumBit(n);
        int s = 0,index = 0;
        for (int i = numBit.size() - 1; i >= 0; i--) {
            s += numBit.get(i);
            if (s > target) {
                // 0 - i位置变成0
                index = i;
                break;
            }
        }
        for (int i = 0; i <= index; i++) {
            numBit.set(i,0);
        }
        int tmp = 1;
        for (int j = index + 1;j <= numBit.size(); j++){

            if (j < numBit.size()) {
                tmp = numBit.get(j) + tmp;
                numBit.set(j,tmp%10);
            }
            else numBit.add(tmp%10);

            if (tmp > 10) tmp/=10;
            else break;
        }
        while (numBit.size() > 1 && numBit.get(numBit.size() - 1) == 0) numBit.remove(numBit.size() - 1);
        StringBuilder stringBuilder = new StringBuilder();
        Collections.reverse(numBit);
        for (int integer : numBit) {
            stringBuilder.append(integer);
        }
        long l = Long.parseLong(stringBuilder.toString());
        if (getSumByBit(n) > target) {
            return l - n +makeIntegerBeautiful(l,target);
        }
        return l - n;
    }

    private int getSumByBit(long n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    private List<Integer> getNumBit(long n){
        ArrayList<Integer> res = new ArrayList<>();
        while (n != 0) {
            res.add((int)(n % 10));
            n /= 10;
        }
        return res;
    }

    @Test
    public void test(){
//        System.out.println(makeIntegerBeautiful(16, 6));
//        System.out.println(makeIntegerBeautiful(467, 6));
//        System.out.println(makeIntegerBeautiful(999, 1));
//        System.out.println(makeIntegerBeautiful(19, 1));
        System.out.println(makeIntegerBeautiful(204932336, 16));
    }



}
