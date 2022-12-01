package indi.xm.ds_algo.leetcode.sn.SN2000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1822
 * @Author: albert.fang
 * @Description: 20221027 打卡
 *
 * @Date: 2022/10/27 16:14
 */
public class SN1822 {

    public int arraySign(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            else if (num < 0) i ++;
        }
        return (i & 1) == 0 ? 1 : -1;
    }

}
