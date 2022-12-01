package indi.xm.ds_algo.competition.acwing.th79.t1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * t1
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prefix = new int[510];
        for (int i = 1; i < 510; i++) {
            prefix[i] = prefix[i-1] + i;
        }
        for (int i = 0; i < 510; i++) {
            if (prefix[i] == n) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }


}
