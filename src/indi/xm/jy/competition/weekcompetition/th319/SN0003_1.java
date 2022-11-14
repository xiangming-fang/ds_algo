package indi.xm.jy.competition.weekcompetition.th319;

import indi.xm.jy.leetcode.data_structure.TreeNode;
import org.junit.Test;

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

    // 思路：层序遍历 + 选择排序思想的优化
    // 优化点：减少取最小值的步骤。
    // 1、我们可以先对目标数组进行排序，排序之后的数组记为sorted
    // 2、我们可以用map记录原始数组level，元素对应的元素位置
    // 3、遍历元素数组，遍历下标记为 i
    //   3.1 如果level.get(i) == sorted(i) 则不必交换，因为元素数组当前位置的元素就是第i小元素。
    //   3.2 不相等的话，我们我们可以先取出 在i位置，应该是哪个元素，即 sorted.get(i)记为 shouldV,
    //   同时用shouldV去map取得shouldV在原始数组level中的下标 记为shouldI
    //   因为这时level中的i和shouldI要交换位置，所以在交换之前应该先修改map中的shouldV位置，和 level.get(i) 位置
    //  即：map.put(sorted.get(i),i) 、map.put(level.get(i),shouldI)
    //  最后交换level 中的 i和shouldI 位置元素。
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
        // 这个map的目的是为了减少获取最小值下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < level.size(); i++) {
            map.put(level.get(i),i);
        }
        for (int i = 0; i < size; i++) {
            if (Objects.equals(level.get(i), sorted.get(i))) continue;
            int minI = map.get(sorted.get(i));
            // 注意！！！
            // 在交换前，必须先修改level当前元素，以及当前应该的最小元素即sorted.get(i) 在map中的下标
            map.put(level.get(i),minI);
            map.put(sorted.get(i),i);
            Collections.swap(level,i,minI);
            ans ++;
        }
        return ans;
    }

    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        System.out.println(minChanges(list));
//        list.clear();
//        list.add(4);
//        list.add(3);
//        System.out.println(minChanges(list));
//        list.clear();
        list.add(7);
        list.add(6);
        list.add(8);
        list.add(5);
        System.out.println(minChanges(list));
//        list.clear();
//        list.add(9);
//        list.add(10);
//        System.out.println(minChanges(list));
    }

}
