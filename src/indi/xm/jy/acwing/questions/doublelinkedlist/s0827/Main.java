package indi.xm.jy.acwing.questions.doublelinkedlist.s0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    static int[] l = new int[N];
    static int[] r = new int[N];
    // 当前数组可存储的位置
    static int idx = 0;

    public static void init(){
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    // 移除k位置的元素
    public static void remove(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    // 在k位置元素的右侧增加新元素x（双链表的任何添加都可以转换成这种形式）
    // 往一个元素的左边添加新元素可以写成：add(l[k],x)
    public static void add(int k,int x){
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0){
            String[] ops = br.readLine().split(" ");
            if (ops[0].equals("L")) {
                int x = Integer.parseInt(ops[1]);
                add(0,x);
            }else if (ops[0].equals("R")){
                int x = Integer.parseInt(ops[1]);
                add(l[1],x);
            }else if (ops[0].equals("D")){
                int k = Integer.parseInt(ops[1]);
                // 因为元素是从idx=2开始插入的
                remove(k + 1);
            }else if (ops[0].equals("IL")){
                int k = Integer.parseInt(ops[1]);
                int x = Integer.parseInt(ops[2]);
                add(l[k+1],x);
            }else if (ops[0].equals("IR")){
                int k = Integer.parseInt(ops[1]);
                int x = Integer.parseInt(ops[2]);
                add(k+1,x);
            }

        }

        // 遍历
        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }

    }
}
