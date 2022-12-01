package indi.xm.ds_algo.competition.acwing.th79.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * t2
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double xs = Math.log(n/5.0 + 1) / Math.log(2) ;
        // 真的是一步错步步错啊，为什么要直接取floor，哭死
        int floor = (int)Math.ceil(xs) - 1;
        int remain = n - (int)(5 * (Math.pow(2,floor) - 1));
        double x = Math.pow(2, floor);
        int v = (int) (remain / x);
        int v1 = (int) (remain % x);
        if ((v == 1 && v1 == 0) || v == 0) System.out.println("a");
        else if ((v == 2 && v1 == 0) || v == 1) System.out.println("b");
        else if ((v == 3 && v1 == 0) || v == 2) System.out.println("c");
        else if ((v == 4 && v1 == 0) || v == 3) System.out.println("d");
        else if ((v == 5 && v1 == 0) || v == 4) System.out.println("e");
    }


}
