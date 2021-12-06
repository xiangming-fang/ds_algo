package indi.xm.jy.leetcode.sn.SN2000;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN01816
 * @Author: albert.fang
 * @Description: 截断句子
 * @Date: 2021/12/6 17:41
 */
public class SN01816 {

    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(s1[i]).append(" ");
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    public String truncateSentence01(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' '){
                k --;
            }
            if (k != 0){
                res.append(cur);
            }else {
                break;
            }
        }
        return res.toString();
    }

    public String truncateSentence02(String s, int k) {
        int end = s.length();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' '){
                if (--k == 0){
                    end = i;
                }
            }

        }
        return s.substring(0,end);
    }

    @Test
    public void test(){
        System.out.println(truncateSentence("What is the solution to this problem", 4));
        System.out.println(truncateSentence01("What is the solution to this problem", 4));
        System.out.println(truncateSentence02("What is the solution to this problem", 4));
    }
}
