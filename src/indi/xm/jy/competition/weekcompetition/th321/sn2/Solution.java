package indi.xm.jy.competition.weekcompetition.th321.sn2;

import org.junit.Test;

/**
 * t2
 */
public class Solution {

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
