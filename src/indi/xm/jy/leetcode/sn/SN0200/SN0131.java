package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0131
 * @Author: albert.fang
 * @Description: 分割回文串
 * @Date: 2021/11/11 14:25
 */
public class SN0131 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s,0, new ArrayList<>());
        return res;
    }

    // start 切割线
    private void dfs(String s, int start,ArrayList<String> singleCutting) {
        // 切割线到达字符串末尾表示切割完成，并成功一次
        // 如果不能完美切割（指切割出回文字符串）那么切割线压根不可能会到达字符串末尾
        if (start >= s.length()){
            res.add(new ArrayList(singleCutting));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 判断是否是回文子串
            if (isPlalindrome(s,start,i)){
                // 为啥是 i + 1？
                // 因为左闭右开[start,i+1)
                singleCutting.add(s.substring(start,i + 1));
                dfs(s,i + 1,singleCutting);
                // 回溯
                singleCutting.remove(singleCutting.size() - 1);
            }
        }
    }

    // 判断子串是否是回文子串
    private boolean isPlalindrome(String s, int start, int end) {
        while (end >= start){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test(){
//        System.out.println(partition("aab"));
//        System.out.println(partition("aaa"));
        System.out.println(partition("efe"));
//        System.out.println(isPlalindrome("efe",0,2));
    }

}
