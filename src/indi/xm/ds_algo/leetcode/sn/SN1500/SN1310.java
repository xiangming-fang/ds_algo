package indi.xm.ds_algo.leetcode.sn.SN1500;

/**
 * @author: albert.fang
 * @date: 2021/5/12 11:47
 * @description: 数组异或查询
 * @link: https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */
public class SN1310 {
    public int[] solution01(int[] arr,int[][] queries){
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = getArrayXor(arr,queries[i][0],queries[i][1]);
        }
        return res;
    }

    public int getArrayXor(int[] arr,int start,int end){
        if (start == end){
            return arr[start];
        }
        int result = arr[start] ^ arr[start + 1];
        for (int i = start + 2; i <= end; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(8 ^ 8);
    }
}
