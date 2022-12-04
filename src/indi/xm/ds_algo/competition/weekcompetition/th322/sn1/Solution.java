package indi.xm.ds_algo.competition.weekcompetition.th322.sn1;

import java.util.ArrayList;

/**
 * t1 回环句
 */
public class Solution {

    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        ArrayList<Character> list = new ArrayList<>();
        for (String s1 : s) {
            list.add(s1.charAt(0));
            list.add(s1.charAt(s1.length()-1));
        }
        if (list.get(0) != list.get(list.size() - 1)){
            return false;
        }
        for (int i = 1; i < list.size()-1; i++) {
            if (i+1 < list.size() - 1){
                if (list.get(i) != list.get(++i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
