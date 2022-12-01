package indi.xm.ds_algo.leetcode.sn.SN0600;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0412
 * @Author: albert.fang
 * @Description: Fizz Buzz
 * @Date: 2021/10/13 10:51
 */
public class SN0412 {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                res.add("FizzBuzz");
            }
            else if (i % 3 == 0){
                res.add("Fizz");
            }
            else if (i % 5 == 0){
                res.add("Buzz");
            }
            else {
                res.add(i+"");
            }
        }
        return res;
    }
}
