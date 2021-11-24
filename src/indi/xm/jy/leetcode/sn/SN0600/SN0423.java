package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0423
 * @Author: albert.fang
 * @Description: 从英文中重建数字
 * @Date: 2021/11/24 17:06
 */
public class SN0423 {


    public String originalDigits(String s) {
        // 统计词频
        int[] wordFrequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            wordFrequency[s.charAt(i) - 'a'] ++;
        }
        // 0 - 9 的数字出现几次
        int[] numFrequency = new int[10];

        char[] chars = {'z', 'w', 'x', 's', 'v', 'f', 'o', 'n', 'r', 't'};
        String[] eNums = {"zero", "two", "six", "seven", "five", "four", "one", "nine", "three", "eight"};
        int[] num = new int[]{0,2,6,7,5,4,1,9,3,8};

        for (int i = 0; i < chars.length;) {
            if (wordFrequency[chars[i] - 'a'] == 0){
                i ++;
                continue;
            }
            for (int j = 0; j < eNums[i].length(); j++) {
                wordFrequency[eNums[i].charAt(j) - 'a'] --;
            }
            numFrequency[num[i]] ++;

        }
        // 组装返回结果
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            if (numFrequency[i] > 0) {
                for (int j = 0; j < numFrequency[i]; j++) {
                    res.append(i);
                }
            }
        }
        return res.toString();
    }

    @Test
    public void test(){
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }
}
