package indi.xm.jy.leetcode.Interview;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.Interview
 * @ClassName: Interview0109
 * @Author: albert.fang
 * @Description: 字符串轮转
 * @Date: 2021/9/5 14:18
 */
public class Interview0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }
}
