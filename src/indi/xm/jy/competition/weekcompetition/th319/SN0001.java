package indi.xm.jy.competition.weekcompetition.th319;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 温度转换
 * @Date: 2022/10/21 16:26
 */
public class SN0001 {

    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] =  celsius  * 1.80 + 32.00;
        return ans;
    }

}
