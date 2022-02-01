package indi.xm.jy.leetcode.sn.SN2000;

import java.util.HashSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN2000
 * @ClassName: SN1763
 * @Author: albert.fang
 * @Description: 1763. 最长的美好子字符串
 * @Date: 2022/2/1 21:44
 */
public class SN1763 {

    public String longestNiceSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > ans.length() && check(s.substring(i,j + 1))) ans = s.substring(i,j + 1);
            }
        }
        return ans;
    }
    
    private boolean check(String s){
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            char lowerCase = Character.toLowerCase(aChar);
            char upperCase = Character.toUpperCase(aChar);
            if (!set.contains(lowerCase) || !set.contains(upperCase)) return false;
        }
        return true;
    }
    
}
