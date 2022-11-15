package indi.xm.jy.acwing.questions.singlelinkedlist.s0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.singlelinkedlist.s0826
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 单链表 - 数组实现
 * @Date: 2022/11/15 10:28
 */
public class Main {

    // 数据范围是100000，这里多给5
    static int len = 100005;

    static int[] e = new int[len];
    static int[] ne = new int[len];
    // 链表初始头结点指向的下标，-1 表示空链表
    static int head = -1;
    // 数组下一个可用位置
    static int idx = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Arrays.fill(ne,-1);
        for (int i = 0; i < M; i++) {
            String[] ops = br.readLine().split(" ");
            if (ops[0].equals("H")) {
                int value = Integer.parseInt(ops[1]);
                e[idx] = value;
                ne[idx] = head;
                head = idx ++;
            }else if (ops[0].equals("I")){
                int k = Integer.parseInt(ops[1]);
                int value = Integer.parseInt(ops[2]);
                e[idx] = value;
                ne[idx] = ne[k-1];
                ne[k-1] = idx ++;
            }else if (ops[0].equals("D")){
                int k = Integer.parseInt(ops[1]);
                // k == 0 表示删除链表头结点; 直接讲头指针后移
                if (k == 0) head = ne[head];
                else ne[k-1] = ne[ne[k-1]];
            }
        }
        // 输出打印
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
