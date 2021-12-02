package indi.xm.jy.leetcode.sn.SN0400;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0260
 * @Author: albert.fang
 * @Description: 只出现一次的数字 III
 * @Date: 2021/12/2 15:51
 */
public class SN0260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 提取xor最右边的一个1
        int rightOne = xor & ( ~xor + 1);
        int firstNum = 0;
        for (int num : nums) {
            // 注意这里判断的 & 操作
            if ((rightOne & num) == 0){
                firstNum ^= num;
            }
        }
        int secondNum = xor ^ firstNum;
        res[0] = firstNum;
        res[1] = secondNum;
        return res;
    }
}
