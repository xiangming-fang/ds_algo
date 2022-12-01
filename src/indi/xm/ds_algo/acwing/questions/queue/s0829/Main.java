package indi.xm.ds_algo.acwing.questions.queue.s0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.queue.s0829
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 模拟队列
 * @Date: 2022/11/16 10:07
 */
public class Main {

    static int N = 100010;
    static int tt = -1;
    static int hh = 0;
    static int[] queue = new int[N];

    public static void push(int x) {
        queue[++tt] = x;
    }

    public static void pop() {
        hh ++;
    }

    public static int query(){
        return queue[hh];
    }

    public static String isEmpty(){
        if (hh > tt) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        while (M -- > 0){
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) {
                push(Integer.parseInt(s[1]));
            }
            else if (s[0].equals("pop")){
                pop();
            }
            else if (s[0].equals("query")){
                System.out.println(query());
            }
            else if (s[0].equals("empty")){
                System.out.println(isEmpty());
            }
        }
    }
}
