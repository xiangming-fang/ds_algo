package indi.xm.ds_algo.acwing.basic.basicalgo;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.algo.template
 * @ClassName: BinarySort
 * @Author: albert.fang
 * @Description: 二分模板
 * @Date: 2022/10/26 10:57
 */
public class BinarySearch {

    // bs 整数二分有两个模板，y总说这两个模板在它目前刷题而言，适用于所有整数二分
    // 1、二分的时候当 l=mid,那么r一定等于mid-1,并且 mid 需要补偿1。
    // 2、二分的时候当 r=mid,那么l一定等于mid+1。
    // 记忆方式：男左女友，男的多一杆枪，需要加1；女的不需要或者减去1.

    // 1、左边第一个x; r = mid
    public int binarySearch(int[] arr,int l,int r,int x){
        while (l < r){
            int mid = l + (r-l)/2;
            if (arr[mid] <= x) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 2、右边最后一个x; l = mid
    public int bs(int[] arr,int l,int r,int x){
        while (l < r){
            int mid = l + (r-l+1)/2;
            if (arr[mid] >= x) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    // 浮点数二分模板
    // 保留n位小数,这里假设保留6位 经验值 1e-(n+2)，所以这里是-8
    public double floatBs(double l,double r,double x){
        while ( r - l > 1e-8){
            double mid = l + (r-l)/2;
            if (check(l)) l = mid;
            else r = mid;
        }
        return l;
    }

    private boolean check(double l) {
        return false;
    }

    private boolean check(int i) {
        return true;
    }
}
