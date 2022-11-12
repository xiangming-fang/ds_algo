package indi.xm.jy.competition.weekcompetition.th317;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 最流行的视频创作者
 * @Date: 2022/10/21 16:26
 */
public class SN0002 {

    // 模拟
    // 1、用遍历creators和views，ids，得到一个map1为：key -> creator,value -> 播放总量；还能得到一个map2为：key -> creator,value -> {index1,index2……}
    // 2、遍历map1，得到得到最大的播放总量为max
    // 3、再次遍历map1,筛选播放量等于max的key，用这个key去map2查找｛index1,index2……}
    // 4、遍历{index1,index2……} => 用index去取views数组取最大的max，并且这个max对应下标index在ids数组里是最小的id
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Long> map1 = new HashMap<>();
        HashMap<String, List<Integer>> map2 = new HashMap<>();
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            map1.put(creators[i],map1.getOrDefault(creators[i],0L) + views[i]);
            if (map2.get(creators[i]) == null) {
                ArrayList<Integer> idList = new ArrayList<>();
                idList.add(i);
                map2.put(creators[i],idList);
            }else {
                map2.get(creators[i]).add(i);
            }
        }
        // max 就是取拍好序的最后一个，排序方式自己定义
        long max = map1.values().stream().max((e1, e2) -> (int) (e1 - e2)).get();
        List<List<String>> res = new ArrayList<>();
        map1.forEach((k,v) -> {
            if (v == max){
                List<String> list = new ArrayList<>();
                list.add(k);
                String id = null;
                int partMax = -1;
                // 通过一次遍历两个数组，找到符合条件的那个值
                for (Integer index : map2.get(k)) {
                    if (views[index] > partMax){
                        partMax = views[index];
                        id = ids[index];
                    }
                    else if (views[index] == partMax){
                        if (id.compareTo(ids[index]) > 0) id = ids[index];
                    }
                }
                list.add(id);
                res.add(list);
            }
        });

        return res;
    }


//    ["alice","alice","alice"]
//            ["a","b","c"]
//            [1,2,2]

//    ["alice","b"]


}
