package indi.xm.jy.acwing.basic.basicalgo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.algo.template
 * @ClassName: RegionMerge
 * @Author: albert.fang
 * @Description: 区间合并
 * @Date: 2022/11/2 13:26
 */
public class RegionMerge {

    // 区间合并
    // 1、先将区间按左区间界限排序
    // 2、取一个小于最左区间的数值记为 N=-2_000_000_000 作为最开始的左右指针，记为l、r
    // 3、对排好序的区间集合进行遍历：
    //  3.1 如果当前区间的左边界大于维护的r，那么说明当前区间和维护的l、r已经断开了，对l进行判断，如果l ！= N ，则 l,r 就是合并后的区间；更新l等于当前区间的左边界、r等于当前区间的右边界
    //  3.2 否则，更新 r = max(r,当前区间的右边界）
    // 4、遍历结束之后，如果 l != N ，那么 此时 l、r依然是个独立区间

    // 返回合并后的区间
    public static List<Pair<Integer,Integer>> mergeRegion(List<Pair<Integer,Integer>> regions){
        Collections.sort(regions,(a,b) -> a.k - b.k);
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int N = -2_000_000_000;
        int l = N,r = N;
        for (Pair<Integer, Integer> region : regions) {
            if (region.k > r){
                if (l != N) pairs.add(new Pair<>(l,r));
                l = region.k;
                r = region.v;
            }
            else r = Math.max(r,region.v);
        }
        if (l != N) pairs.add(new Pair<>(l,r));
        return pairs;
    }

    // 返回合并后的区间个数
    public static int mergeRegionNums(List<Pair<Integer,Integer>> regions){
        Collections.sort(regions,(a, b) -> a.k - b.k);
        int N = -2_000_000_000;
        int l = N,r = N,res = 0;
        for (Pair<Integer, Integer> region : regions) {
            if (region.k > r){
                if (l != N) res ++;
                l = region.k;
                r = region.v;
            }
            else r = Math.max(r,region.v);
        }
        if ( l != N) res++;
        return res;
    }

    private static class Pair<K,V>{
        public K k;
        public V v;
        public Pair(K k,V v){
            this.k = k;
            this.v = v;
        }
    }
}
