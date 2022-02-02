package indi.xm.jy.leetcode.sn.SN2000;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN2000
 * @Author: albert.fang
 * @Description: 2000. 反转单词前缀
 * @Date: 2022/2/2 16:05
 */
public class SN2000 {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i == - 1) return word;
        StringBuilder res = new StringBuilder();
        for (int j = i; j >= 0 ; j--) {
            res.append(word.charAt(j));
        }
        res.append(word.substring(i + 1));
        return res.toString();
    }
}
