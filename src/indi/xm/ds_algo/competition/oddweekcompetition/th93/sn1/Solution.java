package indi.xm.ds_algo.competition.oddweekcompetition.th93.sn1;


/**
 * t1
 */
public class Solution {


    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                    max = Math.max(max,str.length());
                    flag = false;
                    break;
                }
            }
            if (flag) max = Math.max(max,Integer.parseInt(str));
        }
        return max;
    }

}
