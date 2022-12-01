package indi.xm.ds_algo.leetcode.sn.SN1000;

import indi.xm.ds_algo.leetcode.data_structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 从叶结点开始的最小字符串
public class SN0988 {

    // 思路
    // 1、虽然题目要求从叶子节点到根节点，但是其实我们可以保存所有根节点到叶子节点的所有路径。
    // 2、然后再翻转从根节点到叶子节点的所有路径。
    // 3、最后比较反转之后的所有路径字典序
    // 4、取字典序最小的那个路径
    public String smallestFromLeaf(TreeNode root) {
        List<String> allPath = new ArrayList<>();
        backtracking(root,allPath,new ArrayList<>());
        // sorted 是 lambda 表达式里的排序方式，默认都是升序排序的，所以这里也是以字典序升序的排序
        // 取第一个即可
        return allPath.stream().sorted().collect(Collectors.toList()).get(0);
    }

    private void backtracking(TreeNode node, List<String> allPath, ArrayList<Character> path) {
        if (node == null){
            // 方便同一回溯
            path.add(' ');
            return;
        }
        path.add((char)(node.val + 'a'));
        if (node.left == null && node.right == null){
            allPath.add(getString(new ArrayList<>(path)));
            return;
        }

        backtracking(node.left,allPath,path);
        path.remove(path.size() - 1);
        backtracking(node.right,allPath,path);
        path.remove(path.size() - 1);
    }

    private String getString(ArrayList<Character> path){
        Collections.reverse(path);
        StringBuilder res = new StringBuilder();
        for (Character character : path) {
            res.append(character);
        }
        return res.toString();
    }

    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("acsfs");
        list.add("ac");
        list.add("abcsfs");
        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
    }

}
