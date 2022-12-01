package indi.xm.ds_algo.acwing.questions.binarysearch.s0789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.binarysearch.s0791
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 数的范围
 * @Date: 2022/10/26 10:13
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int q = Integer.parseInt(firstLine.split(" ")[1]);
        String sLine = br.readLine();
        int[] arr = new int[n];
        String[] sNums = sLine.split(" ");
        for (int i = 0; i < sNums.length; i++) {
            arr[i] = Integer.parseInt(sNums[i]);
        }
        for (int i = 0; i < q; i++) {
            int singleNum = Integer.parseInt(br.readLine());
            binarySearch(arr,0,n-1,singleNum);
        }
    }

    private static void binarySearch(int[] arr, int l, int r, int num) {

        int i = l,j=r;
        while ( l < r ){
            int mid = l + (r-l)/2;
            if (arr[mid] >= num) r = mid;
            else l = mid + 1;
        }
        if (arr[l] != num) {
            System.out.println("-1 -1");
            return;
        }
        else System.out.print(l + " ");

        l = i;
        r = j;
        while ( l < r){
            int mid = l + (r-l + 1)/2;
            if (arr[mid] <= num) l = mid;
            else r = mid - 1;
        }
        System.out.print(l + "\n");
    }


}
