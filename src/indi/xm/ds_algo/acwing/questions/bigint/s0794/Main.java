package indi.xm.ds_algo.acwing.questions.bigint.s0794;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.questions.bigint.s0794
 * @ClassName: Main
 * @Author: albert.fang
 * @Description: 高精度 a / 低精度 B
 * @Date: 2022/10/27 11:43
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int B = Integer.parseInt(br.readLine());
        int i = first.length() - 1;
        ArrayList<Integer> a = new ArrayList<>();
        while (i >= 0) a.add(first.charAt(i--) - '0');
        Pair<ArrayList<Integer>,Integer> ans = div(a,B);
        i = ans.getKey().size() - 1;
        while (i >=0 ) System.out.print(ans.getKey().get(i--));
        System.out.print("\n" + ans.getValue());
    }

    private static Pair<ArrayList<Integer>, Integer> div(ArrayList<Integer> a, int B) {
        int tmp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = a.size() - 1; i>=0;i--){
            tmp = tmp * 10 + a.get(i);
            ans.add(tmp/B);
            tmp %= B;
        }
        Collections.reverse(ans);
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) ans.remove(ans.size() - 1);
        return new Pair<>(ans,tmp);
    }

    static class Pair<T,F>{
        T key;
        F value;
        public Pair(T t,F f){
            key = t;
            value = f;
        }
        public T getKey(){
            return key;
        }
        public F getValue(){
            return value;
        }
    }


}
