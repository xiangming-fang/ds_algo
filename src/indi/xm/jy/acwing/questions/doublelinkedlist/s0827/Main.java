package indi.xm.jy.acwing.questions.doublelinkedlist.s0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.doublelinkedlist.s0827
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 双链表
 * @Date: 2022/11/15 17:09
 */
public class Main {

    static int N = 100010;

    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] pre = new int[N];

    static int head = -1;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Arrays.fill(ne,-1);
        Arrays.fill(pre,-1);
        while (M-- > 0){
            String[] ops = br.readLine().split(" ");
            if (ops[0].equals("L")) {
                int x = Integer.parseInt(ops[1]);
                e[idx] = x;
                if (head != -1) pre[head] = idx;
                ne[idx] = head;
                head = idx ++;
            }else if (ops[0].equals("R")){
                int x = Integer.parseInt(ops[1]);
                e[idx] = x;
                pre[idx] = idx - 1;
                if (idx - 1 != -1) ne[idx - 1] = idx;
                if (head == -1) head = idx;
                idx ++;
            }else if (ops[0].equals("D")){
                int k = Integer.parseInt(ops[1]);
                if (pre[k-1] != -1) ne[pre[k-1]] = ne[k-1];
                if (ne[k-1] != -1)  pre[ne[k-1]] = pre[k-1];
                if (pre[k-1] == -1 && ne[k-1] == -1) head = -1;
            }else if (ops[0].equals("IL")){
                int k = Integer.parseInt(ops[1]);
                int x = Integer.parseInt(ops[2]);
                e[idx] = x;
                pre[idx] = pre[k-1];
                ne[idx] = k-1;
                if (pre[k-1] != -1) ne[pre[k-1]] = idx;
                pre[k-1] = idx;
                idx ++;
            }else if (ops[0].equals("IR")){
                int k = Integer.parseInt(ops[1]);
                int x = Integer.parseInt(ops[2]);
                e[idx] = x;
                pre[idx] = k-1;
                ne[idx] = ne[k-1];
                if (ne[k-1] != -1) pre[ne[k-1]] = idx;
                ne[k-1] = idx;
                idx ++;
            }



        }

        // 遍历
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }

//        System.out.println();
//        for (int i = idx - 1; i != -1; i = pre[i]){
//            System.out.print(e[i] + " ");
//        }
    }
}
