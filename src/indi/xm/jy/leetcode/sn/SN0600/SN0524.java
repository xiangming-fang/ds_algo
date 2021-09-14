package indi.xm.jy.leetcode.sn.SN0600;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  通过删除字母匹配到字典里最长单词
 */
public class SN0524 {

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            if (!isSequence(s,word)){
                continue;
            }
            if (res.length() > word.length() || (res.length() == word.length() && res.compareTo(word) < 0)){
                continue;
            }
            res = word;
        }
        return res;
    }

    /**
     * 判断 seq 是否是 word 的子序列
     * @param word
     * @param seq
     * @return
     */
    private boolean isSequence(String word,String seq){
        // 如果word比seq短，那么肯定不是
        if (word.length() < seq.length()){
            return false;
        }
        int w = 0,s = 0;
        while (w <= word.length() - 1 && s <= seq.length() - 1){
            if (word.charAt(w) == seq.charAt(s)){
                s ++;
            }
            w ++;
        }
        // 通过w和s指针的移动，如果最后s指针移动到seq字符串的最后一个字符的下一个
        // 那么表示seq 是 word 的 子序列
        return s == seq.length();
    }

    @Test
    public void test(){
//        System.out.println(isSequence("abcdefghijklmn", "abcm"));
//        System.out.println(isSequence("abcdefghijklmn", "abom"));
//        System.out.println(isSequence("abcdefghijklmn", "defgh"));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("a","b","c")));
    }
}
