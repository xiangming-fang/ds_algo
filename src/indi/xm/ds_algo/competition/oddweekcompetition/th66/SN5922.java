package indi.xm.ds_algo.competition.oddweekcompetition.th66;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//  统计出现过一次的公共字符串
public class SN5922 {


    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        for (String s : words1) {
            if (map1.containsKey(s)){
                map1.put(s,map1.get(s) + 1);
            }else {
                map1.put(s,1);
            }
        }
        for (String s : words2) {
            if (map2.containsKey(s)){
                map2.put(s,map2.get(s) + 1);
            }else {
                map2.put(s,1);
            }
        }
        List<String> once1 = map1.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        List<String> once2 = map2.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        int res = 0;
        for (String s : once1) {
            if (once2.contains(s)) {
                res ++;
            }
        }
        return res;
    }


}
