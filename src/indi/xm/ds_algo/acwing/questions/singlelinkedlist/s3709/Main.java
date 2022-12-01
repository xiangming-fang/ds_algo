package indi.xm.ds_algo.acwing.questions.singlelinkedlist.s3709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.singlelinkedlist.s3709
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 单链表节点交换
 * @Date: 2022/11/15 13:53
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int[] e = new int[n];
        for (int i = 0; i < sarr.length; i++) {
            e[i] = Integer.parseInt(sarr[i]);
        }
        int i = 0;
        while (i < n){
            if (i + 1 < n) {
                int tmp = e[i];
                e[i] = e[i+1];
                e[i+1] = tmp;
            }
            i += 2;
        }
        for (int num : e) {
            System.out.print(num + " ");
        }
    }
}
