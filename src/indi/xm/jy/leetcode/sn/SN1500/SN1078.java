package indi.xm.jy.leetcode.sn.SN1500;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 1078. Bigram 分词
public class SN1078 {

    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> ret = new ArrayList<>();
        String[] s = text.split(" ");

        if (s.length < 3){
            return convertArray(ret);
        }

        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].equals(first) && s[i+1].equals(second)){
                ret.add(s[i+2]);
            }
        }

        return  convertArray(ret);
    }


    private String[] convertArray(List<String> arr){
        int len = arr.size();
        String[] ret = new String[len];
        for (int i = 0; i < len; i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }

    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("asdf");
        strings.add("asdfasdf");
        strings.add("asdf324324asdf");
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(12);
        integers.add(1345);
        integers.add(13489);
//        System.out.println(Arrays.toString(convertArray(strings)));
//        System.out.println(Arrays.toString((String[])strings.toArray()));
//        System.out.println(Arrays.toString(convertArray(integers)));
//        System.out.println(Arrays.toString((Integer[])integers.toArray()));
    }

}
