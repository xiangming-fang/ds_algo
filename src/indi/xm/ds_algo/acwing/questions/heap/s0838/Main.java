package indi.xm.ds_algo.acwing.questions.heap.s0838;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: albert.fang
 * @Description: 堆排序
 * @Date: 2022/12/13 10:59
 */
public class Main {

    static int size = 0;

    // 堆排序
    // 1、堆化数组，从 n/2 -> 1 位置依次down操作，目的是为了得到一个堆。
    // 2、弹出堆顶元素，即nums[1]，然后用堆的末尾元素放入第1个位置，再执行down(1)操作。
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] nums = br.readLine().split(" ");
        int[] origins = new int[n+1];
        for (int i = 0; i < nums.length; i++) {
            origins[i+1] = Integer.parseInt(nums[i]);
            size ++;
        }
        for (int i = n/2; i > 0; i--) {
            down(origins,i);
        }
        while (m-- > 0) System.out.print(poll(origins) + " ");
    }


    public static int poll(int[] nums){
        int res = nums[1];
        nums[1] = nums[size--];
        down(nums,1);
        return res;
    }

    public static void down(int[] nums,int index){
        int t = index;
        if (2 * index <= size && nums[2*index] < nums[t]) t = 2 * index;
        if (2 * index + 1 <= size && nums[2*index+1] < nums[t]) t = 2 * index + 1;
        if (t != index){
            int tmp = nums[index];
            nums[index] = nums[t];
            nums[t] = tmp;
            down(nums,t);
        }
    }

}
