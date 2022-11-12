package indi.xm.jy.competition.weekcompetition.th318;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th318
 * @ClassName: SN0003_1
 * @Author: albert.fang
 * @Description: 最小代价
 * @Date: 2022/11/6 19:57
 */
public class SN0003_1 {

    // 思路：最小堆 + 双指针
    // 1、如果最初的candidates * 2 大于等于 costs 长度，说明左右两边候选人出现重复，或者costs中间没有空余候选人；
    // 此时，我们可以直接讲costs排序，取前k个即可。
    // 2、如果 candidates * 2 小于 costs 长度，说明中间出现空闲候选人；
    //    2.1、此时，我们应该创建一个最小堆，最小堆存储的并不是costs值，而是具体costs的下标
    //    排序规则：（e1,e2）-> return cost[e1] != cost[e2] ? cost[e1] - cost[e2] : e1 - e2
    //    含义解读： 如果e1和e2位置的开销不相等的话，取对应的开销更小值；相等的话，取坐标的更小值。
    //    2.2、最小堆定义好了，那么此时我们就应该将cost的下标放进去了，分别是cost的前candidates个下标，以及cost的后candidates下标
    //    2.3、因为我们要选k次，所以遍历k
    //        2.3.1、中间空出来的候选人，我们定义左边界是l、右边界是r
    //        2.3.2、将最小堆堆顶元素出队，出堆的是在cost的下标数组，记为index，也就是最小花费
    //        2.3.3、如果 l<=r，说明中间还是有空出来的候选人的：
    //        此时我们判断，判断index是小于l的还是大于r的，如果是小于l的，说明堆顶元素在左边，此时应该l++,否则r--;同时往堆中添加l或者r下标。
    //        2.3.4、如果 l > r了，说明左右两边又存在交叉了，直接一直弹出堆顶元素即可。
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int len = costs.length;
        if (len <= candidates << 1){
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((e1,e2) -> costs[e1] != costs[e2] ? costs[e1] - costs[e2] : e1 - e2);
        for (int i = 0; i < candidates; i++) {
            q.add(i);
            q.add(costs.length - 1 - i);
        }
        int l = candidates,r = costs.length - candidates - 1;
        while (k > 0){
            int index = q.poll();
            res += costs[index];
            if (l <= r) {
                q.offer(index < l ? l ++ : r--);
            }
            k --;
        }
        return res;
    }

}
