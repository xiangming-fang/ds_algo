package indi.xm.jy.leetcode.sn.SN1000;


import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

/**
 * 分割平衡字符串
 */
public class SN1221 {
    // 方法二：指针
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L'){
                count ++;
            }
            if (s.charAt(i) == 'R'){
                count --;
            }
            if (count == 0){
                res ++;
            }
        }
        return res;
    }

    // 方法一：映射
    public int balancedStringSplit01(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L'){
                if (map.containsKey('L')) {
                    map.put('L',map.get('L') + 1);
                }else {
                    map.put('L',1);
                }
            }
            if (s.charAt(i) == 'R'){
                if (map.containsKey('R')) {
                    map.put('R',map.get('R') + 1);
                }else {
                    map.put('R',1);
                }
            }
            if (Objects.equals(map.getOrDefault('L', 0), map.getOrDefault('R', -1))){
                map.clear();
                res ++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }
}
