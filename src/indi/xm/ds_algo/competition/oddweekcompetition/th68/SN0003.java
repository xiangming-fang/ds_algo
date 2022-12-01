package indi.xm.ds_algo.competition.oddweekcompetition.th68;

import org.junit.Test;

import java.util.Stack;

public class SN0003 {

    public boolean canBeValid(String s, String locked) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        if (isSuit(s)) return true;
        int len = locked.length();
        for (int i = 0; i < len; i++) {
            if (locked.charAt(i) == 0){
                char c = s.charAt(i);
                if (c == '(' && i - 1 >= 0 && s.charAt(i - 1) == '('){
                    s = concat(s,i,')');
                }
                if (c == ')' && i + 1 < len && s.charAt(i + 1) == ')'){
                    s = concat(s,i,'(');
                }
            }
        }

        return isSuit(s);
    }

    private String concat(String s,int index,char c){
        s = s.substring(0,index) + c + s.substring(index + 1);
        return s;
    }

    private boolean isSuit(String s){
        int index = 0;
        Stack<Character> stack = new Stack<>();
        while (index < s.length()){
            if (s.charAt(index) == '('){
                stack.push('(');
            }
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            index ++;
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        System.out.println(isSuit("((()))"));
        System.out.println(isSuit("((()()))"));
        System.out.println(isSuit("((()()))))"));
        System.out.println(concat("asd", 1, 'c'));
    }

}
