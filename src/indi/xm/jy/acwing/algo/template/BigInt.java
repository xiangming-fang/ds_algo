package indi.xm.jy.acwing.algo.template;

import java.util.ArrayList;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.algo.template
 * @ClassName: BigInt
 * @Author: albert.fang
 * @Description: 大整型高精度计算模板：高精度：len(a) > 1000, a 这个数字的长度大于1000位
 * @Date: 2022/10/26 14:03
 */
public class BigInt {

    // 高精度a + 高精度b
    public ArrayList<Integer> add(ArrayList<Integer> a,ArrayList<Integer> b){
        // 进位
        int tmp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) tmp += a.get(i);
            if (i < b.size()) tmp += b.get(i);
            ans.add(tmp%10);
            tmp /= 10;
        }
        if (tmp!=0) ans.add(tmp);
        return ans;
    }

    // 输入参数，保证 高精度a 大于等于 高精度b
    public ArrayList<Integer> sub(ArrayList<Integer> a,ArrayList<Integer> b){
        // 借位
        int tmp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            tmp = a.get(i) - tmp;
            if (i < b.size()) tmp -= b.get(i);
            ans.add((tmp + 10) % 10);
            if (tmp >= 0) tmp = 0;
            else tmp = 1;
        }
        // 干掉前置0
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) ans.remove(ans.size() - 1);
        return ans;
    }

    // 判断 高精度a 是否大于等于高精度b
    public boolean cmp(ArrayList<Integer> a,ArrayList<Integer> b){
        if (a.size() != b.size()) return a.size() > b.size();
        else{
            for (int i = a.size() - 1; i >= 0; i--) {
                if (!a.get(i).equals(b.get(i))) return a.get(i) > b.get(i);
            }
        }
        return true;
    }

    // 高精度 a * 低精度 B
    // 低精度：通常的数字
    public ArrayList<Integer> mul(ArrayList<Integer> a,int B){
        // 进位
        int tmp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.size() || tmp != 0; i++) {
            if (i < a.size()) tmp += a.get(i) * B;
            ans.add(tmp % 10);
            tmp /= 10;
        }
        while(ans.size() > 1 && ans.get(ans.size() - 1) == 0) ans.remove(ans.size() - 1);
        return ans;
    }




}
