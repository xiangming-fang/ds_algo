package indi.xm.ds_algo.competition.weekcompetition.th321.sn2;

import org.junit.Test;

/**
 * t2 追加字符以获得子序列
 */
public class Solution {

    // 思路：模拟遍历
    // 题意：我们要通过在s末尾追加字符串，使得t是s的子序列
    // 子序列：不必相邻，但是要保证相对位置，eg:aceg 是 abcdefg 的子序列
    // 1、我们可以遍历字符串t，用每个字符去s中匹配，如果能一直匹配到结束，那么说明s已经存在t的子序列了，返回0
    // 2、如果第i个位置已经匹配不到了，那么返回的t剩余的字符串大小： t.length() - i ;
    public int appendCharacters(String s, String t) {
        int index = -1,nf = 0,j = -1;
        for (int i = 0; i < t.length(); i++) {
            int ans = s.indexOf(t.charAt(i), ++index);
            if (ans == -1){
                nf = i;
                break;
            }
            index = ans;
            j = i;
        }
        if(j == t.length() - 1) return 0;
        return t.length() - nf;
    }

    @Test
    public void test(){
        System.out.println(appendCharacters("z", "a"));
        System.out.println(appendCharacters("abc", "a"));
        System.out.println(appendCharacters("abz", "abc"));
        System.out.println(appendCharacters("lbg", "g"));
    }


}
