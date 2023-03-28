package indi.xm.data_structure.skiplist;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Author: xiangming.fang
 * @Date: 2023/3/22 16:04
 */
public class Main {
    public static void main(String[] args) {
        compareSdkAndLdbSkipListTest();
    }

    // 生成没有重复的随机数组
    public static int[] getRandomArray(){
        int[] tmp = new int[800];
        Random rd = new Random();
        for (int i = 0; i < 100; i++) {
            int r = rd.nextInt(800);
            tmp[r] = 1;
        }
        int rdl = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0) rdl++;
        }
        int[] ret = new int[rdl];
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 0 ) continue;
            ret[--rdl] = i;
        }
        return ret;
    }


    public static void compareSdkAndLdbSkipListTest(){
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
        SkipList skipList = new SkipList();
        int[] randomArray = getRandomArray();
        for (int i : randomArray) {
            set.add(i);
            skipList.insert(i);
        }
        int[] tmpSet = new int[randomArray.length];
        int[] tmpSkipList = new int[randomArray.length];

        int i = 0;
        Iterator<Integer> setIterator = set.iterator();
        while (setIterator.hasNext()) {
            tmpSet[i++] = setIterator.next();
        }
        i = 0;
        Iterator<Integer> iterator = skipList.iterator();
        while (iterator.hasNext()) {
            tmpSkipList[i++] = iterator.next();
        }
        for (int j = 0; j < randomArray.length; j++) {
            if (tmpSet[j] != tmpSkipList[j]) {
                throw new RuntimeException("SkipList error");
            }
        }
        System.out.println("congratulation to you");
    }

}
