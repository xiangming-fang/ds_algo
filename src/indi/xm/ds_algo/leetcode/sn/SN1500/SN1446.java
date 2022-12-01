package indi.xm.ds_algo.leetcode.sn.SN1500;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1500
 * @ClassName: SN1446
 * @Author: albert.fang
 * @Description: 连续字符
 * @Date: 2021/12/1 9:39
 */
public class SN1446 {

    public int maxPower(String s) {
        int res = 1;
        int left = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(left) != s.charAt(i)){
                res = Math.max(res,i - left);
                left = i;
            }
            else if (i == s.length() - 1 && s.charAt(left) == s.charAt(i)){
                res = Math.max(res,i - left + 1);
                left = i;
            }

        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("cc"));
        System.out.println(maxPower("letcode"));
        System.out.println(maxPower("leeeeetcode"));
        System.out.println(maxPower("leeeeettttttttttttttttttttttttttttcode"));
        System.out.println(maxPower("abcccccccccccccccccccccccc"));
    }

}
