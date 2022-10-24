package indi.xm.jy.acwing.questions.s0789;

import java.util.Scanner;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.s0789
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 快排
 * @Date: 2022/10/24 18:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        quickSort(arr,-1,arr.length);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 左开右开
    public static void quickSort(int[] arr,int left,int right){
        if (right - left <= 2){
            return;
        }
        int leftCopy = left;
        int rightCopy = right;
        int cur = left + 1;
        int pivot = arr[cur];
        while (cur < right){
            if (arr[cur] > pivot){
                swap(arr,cur,--right);
            }
            else if (arr[cur] < pivot){
                swap(arr,cur++,++left);
            }
            else {
                cur ++;
            }
        }
        quickSort(arr,leftCopy,left + 1);
        quickSort(arr,right - 1,rightCopy);
    }
}
