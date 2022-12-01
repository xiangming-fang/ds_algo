package indi.xm.ds_algo.leetcode.sn.SN0200;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0200
 * @ClassName: SN0139
 * @Author: albert.fang
 * @Description: 139. 单词拆分
 * @Date: 2021/11/29 13:06
 */
public class SN0139 {

    Trie trie;

    HashMap<String,Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String s1 : wordDict) {
            trie.addWord(s1);
        }
        this.trie = trie;
        return backtracking(s);
    }

    private boolean backtracking(String s) {

        if (s.isEmpty()){
            return true;
        }
        if (map.containsKey(s)){
            return map.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            // sub是切割下来的子串
            String sub = s.substring(0, i);
            // 判断sub在wordDict里是否存在
            if (trie.contains(sub)){
                if (backtracking(s.substring(i))){
                    map.put(s,true);
                    return true;
                }
            }

        }
        // 以当前进来的s作为key，进行记忆化
        map.put(s,false);
        return false;
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
            this.root = new Node();
        }

        public void addWord(String word){
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (temp.next.get(cur) == null){
                    temp.next.put(cur,new Node());
                }
                temp = temp.next.get(cur);
            }
            if (!temp.isWord){
                temp.isWord = true;
            }
        }

        // 是否包含这个word
        public boolean contains(String word){
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (temp.next.get(cur) == null) {
                    return false;
                }
                temp = temp.next.get(cur);
            }
            // 有这个路径并不代表包含这个单词，还是要这个路径的结尾是否表示一个单词
            return temp.isWord;
        }
    }

    @Test
    public void test(){
        System.out.println(wordBreak("applepenapple", Stream.of("apple", "pen").collect(Collectors.toList())));
        System.out.println(wordBreak("catsandog", Stream.of("cats", "dog", "sand", "and", "cat").collect(Collectors.toList())));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Stream.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa").collect(Collectors.toList())));

    }


}
