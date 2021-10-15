package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0038
 * @Author: albert.fang
 * @Description: 外观数列
 * @Date: 2021/10/15 9:33
 */
public class SN0038 {

    HashMap<Integer,String> map = new HashMap<>();

    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n,describe(countAndSay(n-1)));
        return map.get(n);
    }

    private String describe(String str){

        List<List<Character>> result = new ArrayList<>();
        List<Character> s = new ArrayList<>();

        char[] chars = str.toCharArray();
        s.add(chars[0]);
        // 1、分割str字符串
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i-1]){
                result.add(s);
                s = new ArrayList<>();
            }
            s.add(chars[i]);
        }
        // chars.length 最后一个添加不进去，放外面处理
        result.add(s);

        // 2、遍历result，组成外观str
        StringBuilder sb = new StringBuilder();
        for (List<Character> sig : result) {
            sb.append(sig.size()).append(sig.get(0));
        }
        return sb.toString();
    }

    @Test
    public void test(){
//        System.out.println(describe("1234555"));
        System.out.println(countAndSay(5));
    }

}
