package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0784
 * @Author: albert.fang
 * @Description: 784. 字母大小写全排列
 * @Date: 2022/1/4 17:01
 */
public class SN0784 {


    private List<String> ret = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        dfs(s,new StringBuilder(),0);

        return ret;
    }

    private void dfs(String s, StringBuilder ans,int start) {
        if (ans.length() == s.length()) {
            ret.add(new String(ans));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c - '0' >= 0 && c - '0' <= 9){
                ans.append(c);
                dfs(s,ans,i + 1);
                ans.deleteCharAt(ans.length() - 1);
            }
            else {
                if ( c - 'a' >= 0 && c - 'a' <= 25){

                    ans.append(c);
                    dfs(s,ans,i + 1);
                    ans.deleteCharAt(ans.length() - 1);

                    int dis = 'A' - 'a';
                    int bigC = c + dis;
                    char big = (char) bigC;
                    ans.append(big);
                    dfs(s,ans,i + 1);
                    ans.deleteCharAt(ans.length() - 1);

                }
                else {

                    ans.append(c);
                    dfs(s,ans,i + 1);
                    ans.deleteCharAt(ans.length() - 1);

                    int dis = 'a' - 'A';
                    int smallC = c + dis;
                    char small = (char) smallC;
                    ans.append(small);
                    dfs(s,ans,i + 1);
                    ans.deleteCharAt(ans.length() - 1);

                }
            }
        }
    }

    @Test
    public void test(){
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
    }


}
