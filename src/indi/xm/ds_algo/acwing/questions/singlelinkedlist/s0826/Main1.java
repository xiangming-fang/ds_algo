package indi.xm.ds_algo.acwing.questions.singlelinkedlist.s0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.singlelinkedlist.s0826
 * @ClassName: Main1
 * @Author: albert.fang
 * @Description: 单链表 结构体实现
 * @Date: 2022/11/15 11:12
 */
public class Main1 {

    // tle
    public static Node head = new Node(-1,null,0);

    static class Node{
        private int value;
        private Node next;
        private int opNum;

        public Node(){

        }

        public Node(int value,Node next,int opNum){
            this.value = value;
            this.next = next;
            this.opNum = opNum;
        }

    }

    public static int opOrder = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] ops = br.readLine().split(" ");
            if (ops[0].equals("H")) {
                int value = Integer.parseInt(ops[1]);
                head.next = new Node(value,head.next,opOrder++);
            }else if (ops[0].equals("I")){
                int k = Integer.parseInt(ops[1]);
                int value = Integer.parseInt(ops[2]);
                Node cur = head.next;
                while (cur != null){
                    if (cur.opNum == k) {
                        cur.next = new Node(value,cur.next,opOrder++);
                        break;
                    }
                    cur = cur.next;
                }
            }else if (ops[0].equals("D")){
                int k = Integer.parseInt(ops[1]);
                Node cur = head;
                while (cur != null){
                    if (cur.opNum == k){
                        if (cur.next != null) cur.next = cur.next.next;
                        break;
                    }
                    cur = cur.next;
                }
            }
        }

        Node cur = head.next;
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }
}
