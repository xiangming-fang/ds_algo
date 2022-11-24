package indi.xm.jy.acwing.basic.basicalgo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 离散化：是需要保续的hash方式
 * 将无限空间的有限数据 映射到 有限空间中，提高算法的时间、空间复杂度。
 * 离散化只关心数据之间的相对大小关系，而并不关心具体的数值
 */
public class Discretization {

    // 离散化：将无限空间（坐标）的元素，与有限空间（坐标）的元素一一对应。
    // 离散前 bd: 300、489、23、34、123、3245、3245
    // 离散化后: 4、5、1、2、3、6、6
    // 我们可以看见离散化只关注离散化元素的大小关系，而并不关注离散化的具体值。
    // 因此我们可以将bd用数组存储，并且排序、然后去重。得到一个有序且去重的数组 bd1，这个数组的下标就是离散化后的大小关系，也就是离散化后的大小关系值。（坐标）
    // 创建一个与bd1大小相同的数组记为ad。
    // 如果我们此时给离散化前的位置 3245加上 111 其实就相当于给离散化后的ad[5]加上111.=> 其实这里包含两个操作：1、去bd1查找值为3245的元素下标，记为index。2、修改ad[index] += 111;
    // 总之：离散化前的数组bd里面的元素都是坐标的概念，经过对bd的排序、去重之后得到离散化后的数组bd1.
    // bd1中的元素值是离散化前bd坐标，bd1的下标就是离散化的坐标。
    // 以上就是整个离散化的思想。

    public void discretizationTemplate(){
        ArrayList<Integer> bd = new ArrayList<>();
        /**
         * 给离散化前的bd添加元素 start
         *
         *
         * 添加 end
        **/
        // 排序去重
        Collections.sort(bd);
        int j = 1;
        while (j < bd.size()){
            if (bd.get(j) == bd.get(j-1)) bd.remove(j);
            else j ++;
        }
        int[] ad = new int[bd.size() + 10];
        // 此时bd就是bd1了
        // 找到bd中111的相对位置。
        int index = find(bd, 111);
        ad[index] += 2323;

    }

    // 找从左到右的第一个x
    public int find(List<Integer> bd,int x){
        int l = 0,r = bd.size() -1;
        while (l < r){
            int mid = l + (r-l)/2;
            if (bd.get(mid) >= x) r=mid;
            else l = mid + 1;
        }
        return l;
    }




}

