package indi.xm.jy.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0472
 * @Author: albert.fang
 * @Description: 472. 连接词
 * @Date: 2021/12/28 11:57
 */
public class SN0472 {

    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> res = new ArrayList<>();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            if (word == null || word.equals("")) continue;
            // 是连接词放入 结果集 res
            if (dfs(word,0)) res.add(word);
            // 不是字典树
            else trie.add(word);
        }

        return res;
    }

    // 判断是否是连接词
    private boolean dfs(String word, int start){

        if (start == word.length()){
            return true;
        }

        Trie.Node temp = trie.root;

        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie.Node node = temp.next.get(c);

            if ( node == null) return false;

            if (node.isWord && dfs(word,i + 1)) return true;

            temp = temp.next.get(c);
        }
        return false;
    }

    class Trie{


        class Node{
            TreeMap<Character,Node> next;
            boolean isWord;

            Node(TreeMap<Character,Node> next,boolean isWord){
                this.next = next;
                this.isWord = isWord;
            }

            Node(){
                next = new TreeMap<>();
                isWord = false;
            }
        }

        Node root;

        public Trie(){
            root = new Node();
        }

        public void add(String str){
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c,new Node());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord) cur.isWord = true;
        }

    }

    @Test
    public void test(){
        List<String> allConcatenatedWordsInADict = findAllConcatenatedWordsInADict(new String[]
                {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});

        System.out.println(allConcatenatedWordsInADict.toString());
    }
}
