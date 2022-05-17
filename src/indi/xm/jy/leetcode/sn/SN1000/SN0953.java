package indi.xm.jy.leetcode.sn.SN1000;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0953
 * @Author: albert.fang
 * @Description: 953. 验证外星语词典
 * @Date: 2022/5/17 14:17
 */
public class SN0953 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1){
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int orderKey = 0;
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),++ orderKey);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String next = words[i + 1];
            if (!isLegal(word,next,map)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLegal(String f, String s, Map<Character, Integer> map){
        int fl = f.length();
        int sl = s.length();
        int index = 0;
        while (index < fl && index < sl){
            if (map.get(f.charAt(index)) > map.get(s.charAt(index))) {
                return false;
            }
            else if (map.get(f.charAt(index)) < map.get(s.charAt(index))){
                return true;
            }
            else {
                index ++;
            }
        }
        return index >= fl;
    }

    @Test
    public void test(){

        String[] arr = {"hello","leetcode"};
        boolean ret = isAlienSorted(arr, "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println(ret);
    }

}
