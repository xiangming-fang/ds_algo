package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0028
 * @Author: albert.fang
 * @Description: 实现 strStr()
 * @Date: 2021/9/5 16:24
 */
public class SN0028 {
    public int strStr01(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr(String haystack, String needle) {
        if (Objects.equals(needle, "")){
            return 0;
        }
        else if (needle.length() > haystack.length()){
            return -1;
        }
        int second = 0;
        char first = needle.charAt(second);
        char[] chars = haystack.toCharArray();
        ArrayList<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == first) {
                idxs.add(i);
            }
        }
        for (int i = 0; i < idxs.size(); i++) {
            int idx = idxs.get(i);
            int count = 0;
            if (idx + needle.length() > haystack.length()){
                return -1;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(idx) == needle.charAt(j)) {
                    idx ++;
                    count ++;
                }
            }
            if (count == needle.length()){
                return idxs.get(i);
            }
        }
        return -1;
    }

    @Test
    public void test(){
//        System.out.println(strStr("hello", "ll"));
//        System.out.println(strStr("aaaaa", "bba"));
//        System.out.println(strStr("", ""));
//        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("bbbbabacbbaacbba", "abb"));
    }
}
