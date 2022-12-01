package indi.xm.ds_algo.leetcode.sn.SN1000;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0881
 * @Author: albert.fang
 * @Description: 救生艇
 * @Date: 2021/8/26 10:18
 */
public class SN0881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left <= right){
            if (people[left] + people[right] > limit){
                right --;
                count ++;
            }
            else {
                right --;
                left ++;
                count ++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(numRescueBoats(new int[]{1,2}, 3));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}
