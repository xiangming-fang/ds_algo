package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0720
 * @Author: albert.fang
 * @Description: 词典中最长的单词
 * @Date: 2021/9/7 10:26
 */
public class SN0720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        int[] lens = new int[words.length];
        for (int i = 0; i < lens.length; i++) {
            lens[i] = words[i].length();
        }
        int maxPos = -1;
        int len = 0;
        for (int i = 0; i < lens.length; i++) {
            if (lens[i] > len && contains(words,words[i].substring(0,words[i].length() - 1))){
                maxPos = i;
                len = lens[i];
            }
        }
        return maxPos == -1 ? "" : words[maxPos];
    }

    private boolean contains(String[] arr,String target){
        if ("".equals(target)){
            return true;
        }
        for (String s : arr) {
            if (s.equals(target)){
                return contains(arr,target.substring(0,target.length() - 1));
            }
        }
        return false;
    }

    @Test
    public void test(){
        longestWord(new String[]{"w","wo","wor","worl", "world"});
        System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}));
        System.out.println(longestWord(new String[]{"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"}));
        System.out.println(contains(new String[]{"a", "ab", "abc", "abcd"}, "abcd"));
        System.out.println(contains(new String[]{"a", "ab", "abc"}, "abc"));
        System.out.println(contains(new String[]{"a", "abd", "abc"}, "abc"));
        System.out.println(contains(new String[]{"a", "abd", "abc"}, "abc"));
    }
}
