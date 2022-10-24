package indi.xm.jy.acwing.algo.template;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.algo.template
 * @ClassName: QuickSort
 * @Author: albert.fang
 * @Description: 快排算法模板
 * @Date: 2022/10/24 21:29
 */
public class QuickSort {

    public void quickSort(int[] arr,int l,int r){
        if ( l >= r ) {
            return;
        }
        int i = l - 1,j = r + 1;
        int x = arr[l];
        while ( i < j ){
            do {
                i ++;
            }while (arr[i] < x);
            do {
                j --;
            }while (arr[j] > x);

            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr,l,j);
        quickSort(arr,j + 1,r);
    }

    @Test
    public void test(){
        int[] arr = {3, 5, 6, 4, 7, 10, 9};
        quickSort(arr,0,arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
