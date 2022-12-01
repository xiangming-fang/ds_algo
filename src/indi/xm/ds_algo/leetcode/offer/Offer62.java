package indi.xm.ds_algo.leetcode.offer;

import java.util.TreeMap;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.offer
 * @ClassName: Offer62
 * @Author: albert.fang
 * @Description: 实现前缀树
 * @Date: 2021/11/29 17:03
 */
public class Offer62 {
    private class Trie {

        private class Node{

            private TreeMap<Character,Node> next;
            private boolean isWord;

            public Node(TreeMap<Character,Node> next,boolean isWord){
                this.next = next;
                this.isWord = isWord;
            }

            public Node(){
                this(new TreeMap<Character,Node>(),false);
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (temp.next.get(cur) == null){
                    temp.next.put(cur,new Node());
                }
                temp = temp.next.get(cur);
            }
            temp.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (temp.next.get(cur) == null){
                    return false;
                }
                temp = temp.next.get(cur);
            }
            // 有这个路径并不代表有这个单词
            return temp.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char cur = prefix.charAt(i);
                if (temp.next.get(cur) == null){
                    return false;
                }
                temp = temp.next.get(cur);
            }
            // 直接返回true，代表存在这个路径前缀
            return true;
        }
    }
}
