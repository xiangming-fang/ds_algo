package indi.xm.ds_algo.competition.weekcompetition.th321.sn4;

import java.util.HashMap;

/**
 * t4 统计中位数为 K 的子数组
 */
public class Solution {

    // 题意：找出中位数是k的子数组个数
    // 题目中中位数的定义：
    // 1、如果数组长度是奇数，那么排序之后，最中间的那个数就是中位数
    // 2、如果数组长度是偶数，那么排序之后，取上中位数，即：[1，2，3，4],中位数为2
    // 给出的数组不会包含重复元素，即每个元素都是唯一的。

    // 思路：数学转换

    // 1、我们可以发现，当子数组长度为奇数时，
    // 我们要满足：小于k的个数 == 大于k的个数；这里记小于k的个数为small个，大于k的个数为big个
    // => small == big

    // 2、因为左右两边都可能存在小于k的数字或者大于k的数字
    // => small == big ==> leftSmall + rightSmall  == leftBig + rightBig

    // 3、我们将左边放左边、右边放右边可以得到
    // => leftSmall - leftBig == rightBig - rightSmall
    // 用文字解读就是：左边小于k的个数减去左边大于k的个数 等于 右边大于k的个数 减去右边小于k的个数
    // 当满足这个条件时，那么就是以k为中位数的子数组。

    // 4、上面讨论了子数组为技术的情况，当子数组为偶数时，我们只要满足的是：small + 1 == big
    // 即：leftSmall - leftBig + 1 == rightBig - rightSmall

    public int countSubarrays(int[] nums, int k) {

        // 1、找到元素k的下标位置
        int ki = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ki = i;
                break;
            }
        }
        if (ki == -1) return -1;

        // 2、指针i负责左边遍历，j指针负责右边遍历
        int i = ki - 1,j = ki + 1;
        // 右边依次每个位置 rightBig - rightSmall 的值
        int[] rcount = new int[100005];
        // 3、rmap 是为了记录右边 rightBig - rightSmall 个数，为了快速得到答案，不用一个个遍历
        HashMap<Integer, Integer> rmap = new HashMap<>();
        while (j < nums.length){
            if (nums[j] < k) rcount[j] = rcount[j-1] - 1;
            else rcount[j] = rcount[j-1] + 1;
            j ++;
        }
        for (int ri = ki; ri < nums.length; ri++) {
            rmap.put(rcount[ri],rmap.getOrDefault(rcount[ri],0) + 1);
        }
        // 4、左边每个位置 leftSmall - leftBig 的值
        int[] lcount = new int[100004];
        while (i >= 0){
            if (nums[i] < k) lcount[i] = lcount[i+1] + 1;
            else lcount[i] = lcount[i+1] - 1;
            i --;
        }

        // 5、匹配答案
        int ans = 0;
        for (int li = 0; li <= ki; li++) {
            int v = lcount[li];
            int v1 = lcount[li] + 1;
            // 奇数
            if (rmap.get(v) != null){
                ans += rmap.get(v);
            }
            // 偶数
            if (rmap.get(v1) != null){
                ans += rmap.get(v1);
            }
        }
        return ans;
    }


}
