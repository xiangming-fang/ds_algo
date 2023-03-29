package indi.xm.data_structure.skiplist;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: xiangming.fang
 * @Date: 2023/3/29 10:54
 */
public class SkipListSet<K extends Comparable<K>> implements Set {

    private static final Object IMMUTABLE = null;

    private SkipListMap<K,Object> skipListMap = new SkipListMap();

    @Override
    public int size() {
        return skipListMap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return skipListMap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return skipListMap.contains((K)o);
    }

    @Override
    public Iterator iterator() {

        Iterator iterator = skipListMap.iteratorForSet();

        return new Iterator() {


            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Object next() {
                return iterator.next();
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        try {
            skipListMap.add((K)o,IMMUTABLE);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        try {
            skipListMap.remove((K)o);
        }catch (Exception e){
            return false;
        }
        return true;
    };

    @Override
    public boolean addAll(Collection c) {
        try{
            for (Object o : c) {
                add(o);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        skipListMap.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object o : c) {
            if (!remove(o)) {
                return false;
            }
        }
        return true;
    }

    // what's mean?
    @Override
    public boolean retainAll(Collection c) {
        clear();
        return addAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
