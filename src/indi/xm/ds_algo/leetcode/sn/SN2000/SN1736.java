package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @author: albert.fang
 * @date: 2021/7/24 09:49
 * @description: 1736. 替换隐藏数字得到的最晚时间
 * @link: https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 */
public class SN1736 {

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?'){
                switch (i){
                    case 0:
                        if (chars[i+1] <= '3' || chars[i+1] == '?'){
                            chars[i] = '2';
                        }
                        else {
                            chars[i] = '1';
                        }
                        break;
                    case 1:
                        if (chars[i-1] == '0' || chars[i-1] == '1'){
                            chars[i] = '9';
                        }
                        else if (chars[i-1] == '2'){
                            chars[i] = '3';
                        }
                        break;
                    case 3:
                        chars[i] = '5';
                        break;
                    case 4:
                        chars[i] = '9';
                        break;
                    default:
                        System.out.println("输入的格式有误");

                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            result.append(aChar);
        }
        return result.toString();
    }

    @Test
    public void maximumTimeTest(){
        System.out.println(maximumTime("??:3?"));
    }
}
