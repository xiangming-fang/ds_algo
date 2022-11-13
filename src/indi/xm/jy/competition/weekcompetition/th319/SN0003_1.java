package indi.xm.jy.competition.weekcompetition.th319;

import indi.xm.jy.leetcode.data_structure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.competition.weekcompetition.th001
 * @ClassName: SN0001
 * @Author: albert.fang
 * @Description:
 * @Date: 2022/10/21 16:26
 */
public class SN0003_1 {

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
        List<Integer> sorted = level.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < size; i++) {
            if (Objects.equals(level.get(i), sorted.get(i))) continue;
            int minI = getMinAndIndex(level,i);
            Collections.swap(level,i,minI);
            ans ++;
        }
        return ans;
    }

    public int getMinAndIndex(List<Integer> level,int from){
        int min = Integer.MAX_VALUE,minI = 0;
        for (int i = from; i < level.size(); i++) {
            if (level.get(i) < min) {
                min = level.get(i);
                minI = i;
            }
        }
        return minI;
    }

}
