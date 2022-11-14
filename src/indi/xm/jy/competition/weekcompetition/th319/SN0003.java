package indi.xm.jy.competition.weekcompetition.th319;

import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0003 {

    // tle
    // 思路：选择排序 + 层序遍历
    // 选择排序思想：
    // 1、对[0,n] 的范围的数进行排序，确认第一位的时候，则取[0,n]最小值，找到最小值下index标，与第一位位置进行交换。
    // 2、依次类推，确定第i位元素的具体指，是取[i-1,n]范围的最小值下标index，然后交换index和i位置的元素
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode pop = queue.pop();
                if (pop != null) {
                    level.add(pop.val);
                    queue.offer(pop.left);
                    queue.offer(pop.right);
                }
            }
            ans += minChanges(level);
        }
        return ans;
    }

    public int minChanges(List<Integer> level){
        if (level.size() < 2) return 0;
        int size = level.size(),ans = 0;
        for (int i = 0; i < size; i++) {
            int[] minAndIndex = getMinAndIndex(level,i);
            if (level.get(i) == minAndIndex[0]) continue;
            Collections.swap(level,i,minAndIndex[1]);
            ans ++;
        }
        return ans;
    }

    public int[] getMinAndIndex(List<Integer> level,int from){
        int min = Integer.MAX_VALUE,minI = 0;
        for (int i = from; i < level.size(); i++) {
            if (level.get(i) < min) {
                min = level.get(i);
                minI = i;
            }
        }
        return new int[]{min,minI};
    }

}
