package indi.xm.jy.leetcode.competition.weekcompetition.th313;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 2430.最小XOR
 * @Date: 2022/10/21 16:26
 */
public class SN0003 {

    // 题目描述：找一个数x，x的条件是置位数和num2相同，并且x ^ num1最小
    // 置位数: 正数二进制表示中1的个数

    // 思路：
    // 1. 先计算出num1的置位数个数，并且每个1处于什么位置
    // 2. 计算出num2的置位数个数
    // 3. 结合num1将num2置位数的个数分配
        // 3.1 分配规则：从左往右遍历num1,碰见1就给1，碰见0就给0
        // 3.2 如果num2的置位数个数不够分配则停止
        // 3.3 如果num1见1给1，最后还要多的，又要从右向左遍历x，看见0的部分，依次给1.
    public int minimizeXor(int num1, int num2) {

        int num2Copy = num2;
        int zwsNums = 0;
        int x = 0;
        while (num2Copy != 0){
            if ((num2Copy & 1) == 1) {
                zwsNums ++;
            }
            num2Copy = num2Copy >> 1;
        }
        for (int i = 31; i > 0; i--) {
            int pos = 1 << i;
            if ((pos & num1) == pos && zwsNums > 0){
                x += pos;
                zwsNums --;
            }
        }
        for (int i = 0; i < 32 && zwsNums > 0; i++) {
            int pos = 1 << i;
            if ((pos & x) == 0){
                x += pos;
                zwsNums --;
            }
        }
        return x;

    }

    @Test
    public void test(){
        System.out.println(minimizeXor(1,12));
        System.out.println(minimizeXor(3,5));
    }

}
