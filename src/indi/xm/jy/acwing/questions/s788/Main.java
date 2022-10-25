package indi.xm.jy.acwing.questions.s788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.s788
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 逆序对个数
 * @Date: 2022/10/25 13:47
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
        System.out.print(quickSort(arr,0,arr.length - 1));
    }
    public static long quickSort(int[] arr, int l, int r){
        if (l >= r) return 0;
        int mid = l + (r-l)/2;
        long res = quickSort(arr,l,mid) + quickSort(arr,mid+1,r);
        int i = l,j = mid + 1,k = 0;
        int[] tmp = new int[r - l + 1];
        while (i<=mid && j <= r){
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++];
                res += mid - i + 1;
            }
        }
        while (i<=mid) tmp[k++] = arr[i++];
        while (j<=r) tmp[k++] = arr[j++];
        for (i = l; i <= r; i++) arr[i] = tmp[i-l];
        return res;
    }
}
