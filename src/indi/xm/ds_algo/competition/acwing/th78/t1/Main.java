package indi.xm.ds_algo.competition.acwing.th78.t1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * t1
 */
public class Main {

    // 思路：模拟
    // 1、直接用set
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            set.add(s[0] + "***" + s[1]);
        }
        System.out.println(set.size());
    }


}
