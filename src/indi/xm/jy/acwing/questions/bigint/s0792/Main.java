package indi.xm.jy.acwing.questions.bigint.s0792;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.bigint.s0792
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 大型整数相减
 * @Date: 2022/10/26 15:46
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int i = first.length() - 1;
        while (i >= 0) a.add(first.charAt(i--) - '0');
        i = second.length() - 1;
        while (i >= 0) b.add(second.charAt(i--) - '0');
        ArrayList<Integer> ans;
        if (cmp(a,b)){
            ans = sub(a,b);
        }else {
            ans = sub(b,a);
            System.out.print("-");
        }
        int j = ans.size() - 1;
        while (j >= 0) System.out.print(ans.get(j--));
    }

    public static ArrayList<Integer> sub(ArrayList<Integer> a,ArrayList<Integer> b){
        int tmp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            tmp = a.get(i) - tmp;
            if (i < b.size()) tmp -= b.get(i);
            ans.add((tmp + 10) % 10);
            if (tmp >= 0) tmp = 0;
            else tmp = 1;
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) ans.remove(ans.size() - 1);
        return ans;
    }

    public static boolean cmp(ArrayList<Integer> a,ArrayList<Integer> b){
        if (a.size() != b.size()) return a.size() > b.size();
        else {
            for (int i = a.size() - 1; i >= 0; i --) {
                if (!a.get(i).equals(b.get(i))) return a.get(i) > b.get(i);
            }
        }
        return true;
    }
}
