package indi.xm.jy.acwing.basic.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.acwing.basic.math
 * @ClassName: Divisor
 * @Author: albert.fang
 * @Description: 约数
 * @Date: 2022/11/18 16:39
 */
public class Divisor {


    // 求出一个数的所有约数
    public List<Integer> getDivisors(int x){
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= x/i; i++){
            if(x % i == 0) {
                ans.add(i);
                if(x / i != i) ans.add(x/i);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    @Test
    public void test(){
        List<Integer> divisors = getDivisors(1);
        for (Integer divisor : divisors) {
            System.out.print(divisor + " ");
        }
    }

}
