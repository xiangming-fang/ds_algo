package indi.xm.ds_algo.competition.weekcompetition.th313;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 最大公因子个数
 * @Date: 2022/10/21 16:26
 */
public class SN0001_1 {

    public int commonFactors(int a, int b) {
        int res = 0;
        boolean[] exist = new boolean[1001];
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                exist[i] = true;
                exist[a / i] = true;
            }
        }
        for (int i = 1; i <= b ; i++) {
            if (b % i == 0 && exist[i]){
                res ++;
            }
        }
        return res;
    }

}
