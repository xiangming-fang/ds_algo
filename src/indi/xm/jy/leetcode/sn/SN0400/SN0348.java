package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0348
 * @Author: albert.fang
 * @Description: 打乱数组
 * @Date: 2021/11/22 11:13
 */
public class SN0348 {
    private class Solution {

        private int[] nums;
        // nums 副本
        private int[] copyNums;

        private Random rd = new Random();

        public Solution(int[] nums) {
            this.nums = new int[nums.length];
            this.copyNums = new int[nums.length];
            System.arraycopy(nums,0,this.nums,0,nums.length);
            System.arraycopy(nums,0,this.copyNums,0,nums.length);
        }

        public int[] reset() {
            System.arraycopy(copyNums,0,nums,0,copyNums.length);
            return this.nums;
        }

        public int[] shuffle() {
            // 从末尾开始，每个元素都和[0,i]区间的随机一个元素进行交换
            // 注意这里的终止条件 i > 1 其实等于1也是可以的，只不过等于1的时候，待交换位置就是 i - 1 = 0,ra.nextInt(1)生成的随机数只有0
            // 换句话说就是：当i=1的时候，是首位元素和首位元素本身进行交换，毫无意义，所以可以采取不交换的措施
            // 这也是Collections的shuffle里的源码书写方式，一个小细节
            for (int i = nums.length; i > 1; i--) {
                swap(nums,i - 1,rd.nextInt(i));
            }
            // 那么问题来了，源码里为什么用从后向前的方式遍历呢？
            // 下面我按照源码思想，自己写了一个从前往后的遍历方式
            // 可以看出来，明显可读性没有从后往前更好，要对随机数的范围进行控制，没有从后向前那样方便控制随机数。
            // 看个人理解吧，我是觉得从后往前遍历在这里确实更好理解
//            for (int i = 0; i < nums.length - 1; i++) {
//                swap(nums,i,rd.nextInt(nums.length - i) + i);
//            }
            return nums;
        }

        // 交换元素
        private void swap(int[] arr,int firstPosition,int secondPosition){
            int temp = arr[firstPosition];
            arr[firstPosition] = arr[secondPosition];
            arr[secondPosition] = temp;
        }
    }

    @Test
    public void test(){
        ArrayList<Integer> integers = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        Collections.shuffle(integers);
        System.out.println(integers);
    }
}
