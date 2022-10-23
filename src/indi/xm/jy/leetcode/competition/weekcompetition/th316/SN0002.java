package indi.xm.jy.leetcode.competition.weekcompetition.th316;

import org.junit.Test;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0002 {

    // 思路：
    // 1、找到不能整除k的，作为隔离点
    // 2、计算每个有效区间的最大公约数为k的子数组个数
    // 2.1 统计当前位置j之前有几个k，count;
    // 2.2 若当前位置j是k，那么增加 当前位置 j 减去有效区间左边界 i 再加上 1，即 j - i + 1次
    // 2.3 若当前位置j是k的倍数，那么增加 count次。
    // 3、到新区间，重置，i,j,count。
    public int subarrayGCD(int[] nums, int k) {
        int i = 0;
        int res = 0;
        for (int len = 0; len < nums.length; len++) {
            if (nums[len] % k != 0){
                i = len + 1;
                continue;
            }
            if (nums[len] == k){
                res += len - i + 1;
            }else {
                res += arr(nums,i,len,k);
            }
        }
        return res;
    }

    public int arr(int[] arr,int left,int right,int k){
        int cnt = 0;
        for (int i = right - 1; i >= left; i--) {
            if (gys(arr[i],arr[right]) == k){
                cnt ++;
            }
        }
        if (cnt > 1 && cnt == right - left){
            cnt ++;
        }
        return cnt;
    }

    public int gys(int a,int b){
        int res = 0;
        if (a < b){
            return gys(b,a);
        }
        for (int i = b; i >= 1; i--) {
            if (a % i == 0 && b % i == 0){
                res = i;
                break;
            }
        }
        return res;
    }

    // 欧几里得算法
    public int gcd(int a,int b){
        return a % b == 0 ? b : gcd(b,a % b);
    }

    @Test
    public void test(){
//        System.out.println(subarrayGCD(new int[]{3, 12, 9, 6}, 3));
        System.out.println(gcd(12,6));
        System.out.println(gcd(12,4));
        System.out.println(gcd(12,9));
        System.out.println(gcd(9,12));
        System.out.println(gcd(2,12));
    }
}
