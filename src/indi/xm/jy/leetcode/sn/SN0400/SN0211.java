package indi.xm.jy.leetcode.sn.SN0400;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0211
 * @Author: albert.fang
 * @Description: 包含简单的模式匹配的trie
 * @Date: 2021/10/19 20:19
 */
public class SN0211 {

}

// 带有简单模式的trie
class WordDictionary {

    private class Node{
        public boolean isWord;
        public Map<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return match(root,word,0);
    }

    private boolean match(Node node,String word,int index){
        // 递归到底的情况
        if (index == word.length()){
            // 判断这个节点是否表示一个单词
            return node.isWord;
        }

        char c = word.charAt(index);

        if (c != '.'){
            if (node.next.get(c) == null){
                return false;
            }
            return match(node.next.get(c),word,index + 1);
        }
        else {
            for (Character nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar),word,index + 1))
                    return true;
            }
            return false;
        }
    }
}
