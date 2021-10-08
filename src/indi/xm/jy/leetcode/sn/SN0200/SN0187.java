package indi.xm.jy.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0187
 * @Author: albert.fang
 * @Description: 重复的DNA序列
 * @Date: 2021/10/8 9:50
 */
public class SN0187 {

    // 不管实现的有多low至少是我自己的思想
    // map + 滑动窗口
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() < 10){
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int first = 0;
        int second = 10;
        // 通过滑动窗口得到map
        while (second <= s.length()){
            String temp = s.substring(first, second);
            if (map.containsKey(temp)) {
                map.put(temp,map.get(temp) + 1);
            }else {
                map.put(temp,1);
            }
            first ++;
            second ++;
        }
        // 对map的value进行过滤查找
        List<String> collect = map.entrySet().stream().filter(v -> v.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        res.addAll(collect);
        return res;
    }

    @Test
    public void test(){
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println("AAAAAAAAAAA".length());
    }
}
