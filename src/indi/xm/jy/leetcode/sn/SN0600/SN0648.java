package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0648
 * @Author: albert.fang
 * @Description: 单词替换
 * @Date: 2021/11/29 11:29
 */
public class SN0648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();
        Trie trie = new Trie();
        for (String dic : dictionary) {
            trie.addWord(dic);
        }
        String[] s = sentence.split(" ");
        for (String sl : s) {
            res.append(trie.prefix(sl)).append(" ");
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    private class Trie{

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

        public Trie(){
            // 根的字符是空的，这里是无所谓的
            // 字典树主要是为了向外映射，实现N叉树
            root = new Node();
        }

        public void addWord(String word){
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (temp.next.get(cur) == null){
                    temp.next.put(cur,new Node());
                }
                // 存在字符cur的前缀，temp指针后移
                temp = temp.next.get(cur);
            }
            // 之前该位置不是一个单词结尾，那么修改为是个单词结尾
            if (!temp.isWord){
                temp.isWord = true;
            }
        }

        // 判断是否存在前缀
        public String prefix(String word){
            Node temp = root;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                // 不存在该前缀，直接返回word
                if (temp.next.get(cur) == null){
                    return word;
                }
                res.append(cur);
                // 存在的话后移
                // 首先判断该位置是否是一个单词的结尾
                if (temp.next.get(cur).isWord) {
                    return res.toString();
                }
                temp = temp.next.get(cur);
            }
            return word;
        }
    }

    @Test
    public void test(){
        System.out.println(replaceWords(Stream.of("cat", "bat", "rat","b").collect(Collectors.toList()),
                "the cattle was rattled by the battery"));
    }


}
