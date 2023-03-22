package indi.xm.data_structure.set;

public interface Set<E extends Comparable<E>> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    boolean isEmpty();
    int getSize();
}
