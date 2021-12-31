package indi.xm.jy.leetcode.sn.SN1000;

import org.junit.Test;

import java.util.Arrays;

// 825. 适龄的朋友
public class SN0825 {

    public int numFriendRequests(int[] ages) {
        quickSort(ages,-1,ages.length);
        int ret = 0;
        for (int i = 0; i < ages.length; i++) {
            int x = ages[i];
            int left = 0;
            int right = i;
            int mid;
            int rr = -1;
            while (left <= right){
                mid = left + (right - left >> 1);
                if (canSend(x,ages[mid])) {
                    rr = mid;
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            left = 0;
            right = i;
            int ll = -1;
            while (left <= right){
                mid = left + (right - left >> 1);
                if (canSend(x,ages[mid])) {
                    ll = mid;
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            if (ll != -1 && rr != -1){
                ret += (rr - ll ) + 1;
                if (rr == i) ret --;
            }

        }
        return ret;
    }

    private boolean canSend(int x,int y){
        if (y <= x * 0.5 + 7) return false;
        if (y > 100 && x < 100) return false;
        return y <= x;
    }

    private void quickSort(int[] ages,int left,int right){
        if (right - left <= 2){
            return;
        }

        int copyLeft = left;
        int copyRight = right;
        int cur = left + 1;
        int pivot = ages[cur];
        while (cur < right){
            if (ages[cur] == pivot){
                cur ++;
            }
            else if (ages[cur] < pivot){
                swap(ages,++left,cur++);
            }
            else {
                swap(ages,cur,--right);
            }
        }
        quickSort(ages, copyLeft, left + 1);
        quickSort(ages,right - 1,copyRight);
    }

    private void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int rr(int[] ages){
        int a = 7;
        int left = 0;
        int right = ages.length - 1;
        int mid;
        int rr = 0;
        while (left <= right){
            mid = left + (right - left >> 1);
            if (ages[mid] <= a) {
                rr = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return rr;
    }

    private int ll(int[] ages){
        int left = 0;
        int right = ages.length - 1;
        int ll = 0;
        int mid;
        while (left <= right){
            mid = left + (right - left >> 1);
            if (ages[mid] >= 7) {
                ll = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ll;
    }

    @Test
    public void test(){
//        int[] arr = {2, 3, 1, 5, 6, 5, 4, 3, 2, 3, 4, 5, 6, 7, 8, 8, 9, 1};
//        quickSort(arr,-1,arr.length);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(rr(arr));
//        System.out.println(ll(arr));
//        int[] arr = {16,16};
//        int[] arr = {16,17,18};
        int[] arr = {101,56,69,48,30};
//        int[] arr = {20,30,100,110,120};
        System.out.println(numFriendRequests(arr));
    }

}
