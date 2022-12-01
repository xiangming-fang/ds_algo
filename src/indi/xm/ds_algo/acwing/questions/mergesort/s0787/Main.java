package indi.xm.ds_algo.acwing.questions.mergesort.s0787;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.sn787
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 归并排序
 * @Date: 2022/10/25 13:26
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        mergeSort(arr,0,arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l>=r) return;
        int mid = l + (r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid + 1,r);
        int[] tmp = new int[r - l + 1];
        int k = 0,i = l, j = mid + 1;
        while (i <= mid && j <= r){
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];
        for( i = l; i<=r; i ++) arr[i] = tmp[i-l];
    }
}
