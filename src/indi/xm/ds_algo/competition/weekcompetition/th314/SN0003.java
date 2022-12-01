package indi.xm.ds_algo.competition.weekcompetition.th314;


import org.junit.Test;

import java.util.Stack;

public class SN0003 {

    // 1、遍历s
    // 2、利用先进后出的数据结构：栈,t
    // 3、贪心
    // 3.1 将t中栈顶依次小于等于a-z的弹出
    // 3.2 将s中以a-z的顺序放入t中，如果是最小的话，那么就直接输出打印
    // 4、最后将t中的元素依次弹出

    // 有个核心点：计算出a-z每个元素在字符串中的最后位置
    public String robotWithString(String s) {
        StringBuilder ret = new StringBuilder();
        Stack<Character> t = new Stack<>();
        int[] lastIndexArr = new int[26];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            lastIndexArr[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; i++) {
            while (!t.isEmpty() && t.peek() - 'a' <= i){
                ret.append(t.pop());
            }
            while (k <= lastIndexArr[i]){
                if (s.charAt(k) - 'a' == i) {
                    ret.append(s.charAt(k++));
                }else {
                    t.push(s.charAt(k++));
                }
            }
        }
        int tlen = t.size();
        for (int i = 0; i < tlen; i++) {
            ret.append(t.pop());
        }
        return ret.toString();
    }

    @Test
    public void test(){
        System.out.println(robotWithString("bac"));
        System.out.println(robotWithString("bacdba"));
    }

}
