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
        compareSdkAndMySkipListTest();
    }

    // 生成没有重复的随机数组
    public static int[] getRandomArray(){
        int[] tmp = new int[200_0000];
        Random rd = new Random();
        // 具体大小和这个循环有关
        for (int i = 0; i < 150_0000; i++) {
            int r = rd.nextInt(200_0000);
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
        System.out.println("ldb skipList is same jdk,congratulation to you");
    }

    public static void compareSdkAndMySkipListTest(){
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
        SkipListSet<Integer> skipList = new SkipListSet<>();
        int[] randomArray = getRandomArray();
        for (int i : randomArray) {
            set.add(i);
            skipList.add(i);
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
        System.out.println("mySkipListSet compare to jdk is same,congratulation to you");
    }


    public static void testMySkipListMap(){
        SkipListMap<String,String> skip = new SkipListMap<>();
        skip.add("aa","bb");
        skip.add("ac","bb");
        skip.add("ab","bb");
        skip.add("af","bb");
        skip.add("ae","bb");
        skip.add("az","bb");
        skip.add("aq","bb");
        Iterator iterator = skip.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("***********");
        String af = skip.remove("af");
        // 输出bb
        System.out.println(af);
        Iterator iterator1 = skip.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().toString());
        }
        System.out.println("***********");
        skip.set("ac","xiangming.fang");
        Iterator iterator2 = skip.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
        }
        System.out.println(skip.get("ac"));
    }

    public static void testMySkipListSet(){
        SkipListSet<Integer> skipListSet = new SkipListSet<>();
        for (int i : getRandomArray()) {
            skipListSet.add(i);
        }
        Iterator iterator = skipListSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
