package indi.xm.jy.acwing.questions.hash.s0840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.hash.s0840
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 模拟散列表
 * @Date: 2022/11/22 11:06
 */
public class Main {

    // 模的这个数，尽量取质数，以便减少hash冲突
    // 为什么取100003？
    // 1、首先得是质数
    // 2、其二是因为最多对散列表操作100000次，所以必须大于100000
    int N = 100003;

    // 下标k是x经过hash函数之后计算出来的
    // h[k] = value 是单链表头结点，所以得初始化为-1;
    int[] h = new int[N];
    int[] e = new int[N];
    int[] ne = new int[N];
    int idx = 0;

    // x 的范围是-10e9到10e9
    public int hash(int x){
        // 为什么需要 x 先模上N之后再加N?
        // 因为 x 可能是个负数，模上一个正数之后，也是个大于-N的负数
        return (x % N + N) % N;
    }

    // 往散列表中添加一个元素
    public void add(int x){
        int k = hash(x);
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx ++;
    }

    // 判断散列表中是否存在元素x
    public boolean find(int x){
        int k = hash(x);
        for(int i = h[k]; i != -1; i = ne[i]){
            if(e[i] == x) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(main.h,-1);
        while (n -- > 0){
            String[] s = br.readLine().split(" ");
            if (s[0].equals("I")){
                main.add(Integer.parseInt(s[1]));
            }else {
                if (main.find(Integer.parseInt(s[1]))) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
