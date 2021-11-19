package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

/**
 * 最大单词长度乘积
 */
public class SN0318 {

    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j =  i + 1; j < words.length; j++) {
                if (!checkDuplicate(words[i],words[j])){
                    res = Math.max(res,words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    // true - word1,word2 含有公共字母  false word1,word2 不含有公共字母
    private boolean checkDuplicate(String word1,String word2) {
        int[] help = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            int index = word1.charAt(i) - 'a';
            help[index] = 1;
        }
        for (int i = 0; i < word2.length(); i++) {
            int index = word2.charAt(i) - 'a';
            if (help[index] == 1){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(maxProduct(new String[]{"a","aa","aaa","aaaa"}));
        // expected 15
        System.out.println(maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"}));
    }

}
