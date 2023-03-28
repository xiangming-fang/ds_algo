package indi.xm.data_structure.skiplist;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author: xiangming.fang
 * @Date: 2023/3/22 16:04
 */
public class Main {
    public static void main(String[] args) {
        testSkipList();
    }



    public static void sdkSkipList(){
        // 按key进行排序
        // jdk 里 所有排序都是默认升序的
        ConcurrentSkipListMap<String, String> skipListMap = new ConcurrentSkipListMap<>();
        for (int i = 100; i > 1; i--) {
            skipListMap.put(i+"","asfsadf");
        }
        skipListMap.forEach((k,v) -> {
            System.out.println(k +" " + v);
        });
    }

    public static void testSkipList(){
        SkipList skipList = new SkipList();
        Random rd = new Random();
        for (int i = 0; i < 100; i++) {
            int r = rd.nextInt(800);
            skipList.insert(r);
        }
        skipList.printAll_beautiful();
    }
}
