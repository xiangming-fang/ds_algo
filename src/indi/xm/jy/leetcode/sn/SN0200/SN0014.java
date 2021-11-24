package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

// 最长公共前缀
public class SN0014 {

    StringBuilder res = new StringBuilder();

    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            if (dfs(strs,0,i,strs[0].charAt(i))) {
                res.append(strs[0].charAt(i));
            }else {
                return res.toString();
            }
        }
        return res.toString();
    }

    // 深度优先搜索
    // true - start位置里是符合的
    // false - 不符合
    private boolean dfs(String[] strs, int index,int start,char pendingCompareChar) {
        if (index >= strs.length){
            return true;
        }
        if (start < strs[index].length() && strs[index].charAt(start) == pendingCompareChar){
            return dfs(strs, index + 1, start, pendingCompareChar);
        }
        return false;
    }

    @Test
    public void test(){
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"dogggjjjjjjjjjjj","dogggwew","dogggsafasdf"}));
    }
}
