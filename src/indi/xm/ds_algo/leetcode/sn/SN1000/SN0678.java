package indi.xm.ds_algo.leetcode.sn.SN1000;


import org.junit.Test;

import java.util.Stack;

/**
 * 有效的括号字符串
 */
public class SN0678 {
    public boolean checkValidString(String s) {
        Stack<Integer> charStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char singleChar = s.charAt(i);
            if ( singleChar == '('){
                charStack.push(i);
            }
            else if (singleChar == '*'){
                starStack.push(i);
            }
            else if (singleChar == ')'){
                if (!charStack.isEmpty()){
                    charStack.pop();
                }
                else if (!starStack.isEmpty()){
                    starStack.pop();
                }
                else {
                    return false;
                }
            }
        }
        if (charStack.isEmpty()){
            return true;
        }
        else if (starStack.isEmpty()){
            return false;
        }
        else if (charStack.size() > starStack.size()){
            return false;
        }
        int size = charStack.size();
        for (int i = 0; i < size; i++) {
            Integer charIndex = charStack.pop();
            Integer startIndex = starStack.pop();
            if (charIndex > startIndex) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString( "(*)"));
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("))()"));
        System.out.println(checkValidString("))()"));
        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
//        System.out.println("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()".length());
    }
}
