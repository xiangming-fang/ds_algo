package indi.xm.ds_algo.leetcode.sn.SN1000;

/**
 * @author: albert.fang
 * @date: 2020/9/1 19:00
 * @description: 779：第k个语法符号
 */
public class SN0779 {
    public static int kthGrammar1(int N, int K) {
        String nthRow = getNthRow(N);
        char c = nthRow.charAt(K - 1);
        return Integer.valueOf(String.valueOf(c));
    }

    // 得到具体某行的字符串，暴力递归（超时）
    public static String getNthRow(int n){
        if (n == 1){
            return "0";
        }
        StringBuilder nthRow = new StringBuilder();
        for (char c : getNthRow(n-1).toCharArray()) {
            if (c == '0'){
                nthRow.append("01");
            }
            if (c == '1'){
                nthRow.append("10");
            }
        }
        return nthRow.toString();
    }


    public static int kthGrammar(int N, int K) {
        if ( N == 1){
            return 0;
        }
        int parent = kthGrammar(N-1,(int)Math.ceil((double)K/2));
        if (parent == 0){
            return K%2 == 1 ? 0 : 1;
        }
        return K%2 == 1 ? 1 : 0;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println(getNthRow(i));
        }
//        System.out.println(kthGrammar(30, 10));
    }
}
