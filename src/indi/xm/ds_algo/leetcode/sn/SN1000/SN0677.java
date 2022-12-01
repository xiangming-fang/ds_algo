package indi.xm.ds_algo.leetcode.sn.SN1000;

import java.util.TreeMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN1000
 * @ClassName: SN0677
 * @Author: albert.fang
 * @Description: 键值映射
 * @Date: 2021/10/19 20:37
 */
public class SN0677 {
}
class MapSum {

    private class Node{

        // 用value表示这个节点结束是否是一个单词
        public int value;

        public TreeMap<Character,Node> next;

        public Node(int value){
            this.value = value;
            this.next = new TreeMap<>();
        }

        public Node(){
            this(0);
        }
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        // 到key的最后一个字符了
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    // 遍历node，以及所有以node为根节点的trie
    private int sum(Node node){
        // 递归到底
//        if (node.next.size() == 0)
//            return node.value;

        int res = node.value;
        // 包含了递归到底的条件
        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
