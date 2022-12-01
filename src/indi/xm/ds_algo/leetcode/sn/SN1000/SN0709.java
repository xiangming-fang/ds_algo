package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0709
 * @Author: albert.fang
 * @Description: 709. 转换成小写字母
 * @Date: 2021/12/13 9:34
 */
public class SN0709 {
    public String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        int dis = 'a' - 'A';
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= 'A' && cur <= 'Z'){
                res.append((char) (cur + dis));
            }else {
                res.append(cur);
            }
        }
        return res.toString();
    }

    @Test
    public void test(){
        System.out.println(toLowerCase("Abc BSD"));
    }
}
