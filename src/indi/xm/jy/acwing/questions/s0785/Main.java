package indi.xm.jy.acwing.questions.s0785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.s0789
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 快排
 * @Date: 2022/10/24 18:52
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
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if ( l >= r){
            return;
        }
        int x = arr[l];
        int i = l - 1,j = r + 1;
        while (i < j){
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
}
