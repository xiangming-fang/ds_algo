package indi.xm.ds_algo.leetcode.sn.SN0200;

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

    // 优化
    // 优化点：简化对map的过滤
    public List<String> findRepeatedDnaSequences01(String s) {
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
            Integer value = map.getOrDefault(temp, 0);
            // 最巧妙的地方，让value == 1而不是 value > 1
            if (value == 1) res.add(temp);
            map.put(temp,value + 1);
            first ++;
            second ++;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(findRepeatedDnaSequences01("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences01("AAAAAAAAAAAAA"));
        System.out.println(findRepeatedDnaSequences01("AAAAAAAAAAA"));
        System.out.println("AAAAAAAAAAA".length());
    }
}
