package indi.xm.jy.leetcode.competition.weekcompetition.th313;

import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 最大公因子个数
 * @Date: 2022/10/21 16:26
 */
public class SN0001 {

    public int commonFactors(int a, int b) {
        int res = 0;
        boolean[] existA = new boolean[1001];
        boolean[] existB = new boolean[1001];
        for (int i = 1; i <= a / 2 + 1; i++) {
            if (a % i == 0) {
                existA[i] = true;
                existA[a / i] = true;
            }
        }
        for (int i = 1; i <= b / 2 + 1; i++) {
            if (b % i == 0){
                existB[i] = true;
                existB[b / i] = true;
            }
        }
        for (int i = 0; i < 1001; i++) {
            if (existA[i] && existB[i]) {
                res ++;
            }
        }
        return res;
    }

}
