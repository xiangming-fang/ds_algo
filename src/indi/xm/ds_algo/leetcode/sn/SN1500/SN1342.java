package indi.xm.ds_algo.leetcode.sn.SN1500;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1342
 * @Author: albert.fang
 * @Description: 1342. 将数字变成 0 的操作次数
 * @Date: 2022/1/31 11:33
 */
public class SN1342 {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int ans = 0;
        while (num != 0){
            if ((num & 1) == 0){
                num = num >> 1;
            }
            else {
                num--;
            }
            ans ++;
        }
        return ans;
    }
}
