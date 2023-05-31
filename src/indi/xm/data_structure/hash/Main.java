package indi.xm.data_structure.hash;



import indi.xm.data_structure.map.LinkedListMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @Author: xiangming.fang
 * @Date: 2023/3/29 17:03
 */
public class Main {

    public static void main(String[] args) {
        // 链表？哈希？
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16,0.5f,false);
        map.put(2,324);
        map.put(456,234);
        map.put(789,234);
        map.put(23,234);
        map.put(20,324);
        Integer res20 = map.get(789);
        map.entrySet().forEach(v -> System.out.println(v.toString()));
        System.out.println("*****************");
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(2);
        set.add(234);
        set.add(23);
        set.add(22);
        set.add(20);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        String a = "a";
        String b = "b";
        String c = b = a;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
