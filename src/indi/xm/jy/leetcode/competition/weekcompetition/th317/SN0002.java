package indi.xm.jy.leetcode.competition.weekcompetition.th317;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0002 {

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Integer> a = new HashMap<>();
        HashMap<String, String> b = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            if (a.containsKey(creators[i])) {
                a.put(creators[i],views[i] + a.get(creators[i]));
            }
            else a.put(creators[i],views[i]);
            b.put(creators[i]," " + ids[i]);
        }
        int max = 0;
        // 根据value排序
        a.entrySet().stream().sorted(Map.Entry.comparingByValue());

        return null;
    }
}
