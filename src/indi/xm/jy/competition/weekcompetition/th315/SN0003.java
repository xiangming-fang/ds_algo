package indi.xm.jy.competition.weekcompetition.th315;

import java.util.HashMap;
import java.util.Stack;

public class SN0003 {

    // 打表 - tle
    public boolean sumOfNumberAndReverse(int num) {
        HashMap<Integer, Boolean> hashtable = new HashMap<>();
        for (int i = 0; i <= 100000; i++) {
            hashtable.put(i + reserveNum(i),true);
        }
        return hashtable.get(num) != null;
    }

    public int reserveNum(int num){
        String s = num + "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int sl = stack.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sl; i++) {
            sb.append(stack.pop());
        }
        return Integer.parseInt(sb.toString());
    }

}
