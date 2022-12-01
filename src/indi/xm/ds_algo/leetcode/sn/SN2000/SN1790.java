package indi.xm.ds_algo.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1790
 * @Author: albert.fang
 * @Description: 1790. 仅执行一次字符串交换能否使两个字符串相等
 * @Date: 2022/10/11 20:33
 */
public class SN1790 {


    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }
        int cnt = 0;
        int[] pos = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                if (cnt >= pos.length){
                    return false;
                }
                pos[cnt ++] = i;
            }
        }
        char[] chars = s1.toCharArray();
        char temp = chars[pos[0]];
        chars[pos[0]] = chars[pos[1]];
        chars[pos[1]] = temp;

        return new String(chars).equals(s2);
    }

    @Test
    public void test(){
        System.out.println(areAlmostEqual("bank", "kanb"));
    }



}
