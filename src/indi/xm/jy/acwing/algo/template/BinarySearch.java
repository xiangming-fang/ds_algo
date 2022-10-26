package indi.xm.jy.acwing.algo.template;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.algo.template
 * @ClassName: BinarySort
 * @Author: albert.fang
 * @Description: 二分模板
 * @Date: 2022/10/26 10:57
 */
public class BinarySearch {

    // bs 有两个模板，y总说这两个模板在它目前刷题而言，适用于所有二分
    // 1、二分的时候当 l=mid,那么r一定等于mid-1,并且 mid 需要补偿1。
    // 2、二分的时候当 r=mid,那么l一定等于mid+1。
    // 记忆方式：男左女友，男的多一杆枪，需要加1；女的不需要或者减去1.

    public int binarySearch(int[] arr,int l,int r){
        while (l < r){
            int mid = l + (r-l)/2;
            if (check(arr[mid])) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public int bs(int[] arr,int l,int r){
        while (l < r){
            int mid = l + (r-l+1)/2;
            if (check(arr[mid])) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private boolean check(int i) {
        return true;
    }
}
