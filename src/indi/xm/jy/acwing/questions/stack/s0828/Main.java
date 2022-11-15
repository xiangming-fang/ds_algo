package indi.xm.jy.acwing.questions.stack.s0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.stack.s0828
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 模拟栈
 * @Date: 2022/11/15 22:22
 */
public class Main {

    static int N = 100010;

    static int[] arr = new int[N];
    static int tt = 0;

    public static String isEmpty(){
        if (tt == 0) {
            return "YES";
        }
        return "NO";
    }

    public static void push(int x){
        arr[++tt] = x;
    }

    public static void pop(){
        tt--;
    }

    public static int query(){
        return arr[tt];
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
