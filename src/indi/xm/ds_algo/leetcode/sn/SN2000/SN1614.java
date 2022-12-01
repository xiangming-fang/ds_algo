package indi.xm.ds_algo.leetcode.sn.SN2000;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1614
 * @Author: albert.fang
 * @Description: 1614. 括号的最大嵌套深度
 * @Date: 2022/1/7 18:48
 */
public class SN1614 {
    public int maxDepth(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(aChar);
                res = Math.max(res,stack.size());
            }
            else if (aChar == ')') stack.pop();
        }
        return res;
    }
}
