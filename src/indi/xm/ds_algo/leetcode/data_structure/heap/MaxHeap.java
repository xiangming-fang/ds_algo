package indi.xm.ds_algo.leetcode.data_structure.heap;

import indi.xm.ds_algo.leetcode.data_structure.array.Array;
import org.junit.Test;

import java.util.Random;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.data_structure.heap
 * @ClassName: MaxHeap
 * @Author: albert.fang
 * @Description: 最大堆
 * @Date: 2021/8/27 10:56
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    // 查询父节点下标
    private int parent(int i){
        return (i - 1)/2;
    }

    // 左孩子节点下标
    private int left(int i){
        return i * 2 + 1;
    }

    // 右孩子节点下标
    private int right(int i){
        return (i + 1) * 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // index 待上浮位置
    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0){
            swap(parent(index),index);
            index = parent(index);
        }
    }

    public E remove(){
        if (data.getSize() > 0) {
            swap(0,data.getSize() - 1);
            E res = data.removeLast();
            siftDown(0);
            return res;
        }
        return null;
    }

    // index 下沉位置
    private void siftDown(int index) {
        while (left(index) <= data.getSize() - 1){
            // 待交换节点位置
            int wc;
            // 左右节点都存在，选出左右节点最大的那个
            if (right(index) <= data.getSize() - 1){
                if (data.get(left(index)).compareTo(data.get(right(index))) > 0) {
                    wc = left(index);
                }
                else {
                    wc = right(index);
                }
            }
            // 右节点不存在，就只有左节点了
            else {
                wc = left(index);
            }
            // 比较index 和 wc 的优先级
            if (data.get(index).compareTo(data.get(wc)) < 0){
                swap(index,wc);
                index = wc;
            }
            else {
                break;
            }
        }
    }

    private void swap(int source,int target){
        if (source > target || source < 0 || target > data.getSize() - 1 || source > data.getSize() - 1){
            throw new IllegalArgumentException("交换下标非法: " + source + ", " + target);
        }
        E temp = data.get(source);
        data.set(source,data.get(target));
        data.set(target,temp);
    }

    public int getSize(){
        return data.getSize();
    }

    @Test
    public void test(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            maxHeap.add(random.nextInt(1000000));
        }
        Array<Integer> array = new Array<>();
        int size = maxHeap.getSize();
        for (int i = 0; i < size; i++) {
            array.addLast(maxHeap.remove());
        }
        for (int i = 1; i < array.getSize(); i++) {
            if (array.get(i).compareTo(array.get(i - 1)) > 0) {
                System.out.println("maxHeap 创建失败");
            }
        }
    }
}
