package indi.xm.jy.acwing.questions.hash.s0840_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.hash.s0840
 * @ClassName: Main2
 * @Author: albert.fang
 * @Description: 模拟散列表
 * @Date: 2022/11/22 11:42
 */
public class Main {

    int N = 100003;
    // 存储的就是具体元素值，初始成一个不在x范围内的数，x ~ (-1e9 - 1e9),我们可以考虑初始成Integer.MaxValue
    int[] h = new int[N];

    public int hash(int x){
        return ( x % N + N ) % N;
    }

    // 返回存储x的下标位置，或者下一个应该存储x的位置
    public int find(int x){
        int k = hash(x);
        while(h[k] != Integer.MAX_VALUE && h[k] != x){
            k ++;
            // 一直寻址到末尾都没地方存，将k置为0，从头开始找
            if(k == N) k = 0;
        }
        return k;
    }

    public void add(int x){
        int k = find(x);
        if(h[k] == x) return;
        h[k] = x;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Arrays.fill(main.h,Integer.MAX_VALUE);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n -- > 0){
            String[] s = br.readLine().split(" ");
            if (s[0].equals("I")) main.add(Integer.parseInt(s[1]));
            else {
                if (main.h[main.find(Integer.parseInt(s[1]))] == Integer.MAX_VALUE) System.out.println("No");
                else System.out.println("Yes");;
            }
        }
    }
}
