package indi.xm.jy.leetcode.competition.weekcompetition.th316;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description: 使数组相似的最少操作次数
 * @Date: 2022/10/21 16:26
 */
public class SN0004 {


    // 提示1：我们可以将题目看成是+-1的，那么如果[2,8]  [4,6]
    // 如何分组呢？我们不应该是[2,6]、[8,4]这样分组，因为这样分组的变化量比[2,4] [6,8]这种分组方式变化量更大。
    // 所以我们应该将nums数组和target数组先进行排序，然后计算每个对应元素的变化量。
    // 提示2：题目说的 +-2,奇数+-2还是奇数，偶数+-2还是偶数，所以我们这里需要对奇偶数进行区分
    // 看见这种每次操作+-2，+-3的，首先应该考虑到分组
    // 题目说的保证有答案，所以说nums、target两个数组中的奇偶数个数是一样的。
    // 所以这题应该先对nums和target里的元素进行奇偶区分,然后计算每个对应元素的变化量，将最后结果 / 4 返回
    public long makeSimilar(int[] nums, int[] target) {
        long ans = 0;
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> evenT = new ArrayList<>();
        ArrayList<Integer> oddT = new ArrayList<>();
        for (int num : nums) {
            if ((num & 1) == 0) even.add(num);
            else odd.add(num);
        }
        for (int t : target) {
            if ((t & 1) == 0) evenT.add(t);
            else oddT.add(t);
        }
        even.sort(Comparator.comparingInt(a -> a));
        odd.sort(Comparator.comparingInt(a -> a));
        evenT.sort(Comparator.comparingInt(a -> a));
        oddT.sort(Comparator.comparingInt(a -> a));
        int evenLen = even.size(),oddLen = odd.size();
        for (int i = 0; i < evenLen; i++) ans += Math.abs(even.get(i) - evenT.get(i));
        for (int i = 0; i < oddLen; i++) ans += Math.abs(odd.get(i) - oddT.get(i));
        return ans / 4;
    }

}
