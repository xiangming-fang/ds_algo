package indi.xm.jy.acwing.questions.bigint.s0791;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.bigint.s0791
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 大整型数相加
 * @Date: 2022/10/26 14:36
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        ArrayList<Integer> aa = new ArrayList<>();
        ArrayList<Integer> bb = new ArrayList<>();
        int i = a.length() - 1;
        while (i >= 0) aa.add(a.charAt(i--) - '0');
        i = b.length() - 1;
        while (i >= 0) bb.add(b.charAt(i--) - '0');
        ArrayList<Integer> c = add(aa, bb);
        int size = c.size();
        while (size > 0) System.out.print(c.get(--size));
    }

    public static ArrayList<Integer> add(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> ans = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i<a.size() || i < b.size();i++){
            if (i < a.size()) tmp += a.get(i);
            if (i < b.size()) tmp += b.get(i);
            ans.add(tmp%10);
            tmp /=10;
        }
        if (tmp != 0) ans.add(tmp);
        return ans;
    }
}
