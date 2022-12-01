package indi.xm.ds_algo.leetcode.sn.SN0600;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0600
 * @ClassName: SN0692
 * @Author: albert.fang
 * @Description: 前K个高频单词
 * @Date: 2021/11/29 10:44
 */
public class SN0692 {

    // 装一下，这里不用hash表做
    // 用字典树做
    public List<String> topKFrequent01(String[] words, int k) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        Collections.addAll(set, words);
        for (String s : set) {
            map.put(s,trie.getWordFrequency(s));
        }
        List<String> collect = map.entrySet().stream().sorted((v1, v2) -> {
            if (v1.getValue() - v2.getValue() > 0) {
                return -1;
            } else if (v1.getValue() - v2.getValue() < 0) {
                return 1;
            } else {
                if (v1.getKey().compareTo(v2.getKey()) > 0) {
                    return 1;
                } else if (v1.getKey().compareTo(v2.getKey()) < 0) {
                    return -1;
                }
                return 0;
            }
        }).map(Map.Entry::getKey).collect(Collectors.toList());
        return collect.subList(0,k);
    }

    // 实现一个简易版的字典树（这题够用就好）
    private class Trie{

        private class Node{
            private TreeMap<Character,Node> next;
            private Integer count;

            public Node(TreeMap<Character,Node> next,int count){
                this.next = next;
                this.count = count;
            }

            public Node(){
                this(new TreeMap<>(),0);
            }
        }

        private Node root;

        public Trie(){
            root = new Node();
        }

        // 添加单词，并且同时记录词频
        public void addWordAndRecordFrequency(String word,int[] frequencyK){
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (temp.next.get(cur) == null){
                    // 当前字典树不包含该前缀，那么加入
                    temp.next.put(cur,new Node());
                }
                // 有这个字符的前缀，那么temp后移
                temp = temp.next.get(cur);
            }
            // 词频 + 1
            temp.count ++;
            findMinAndReplace(frequencyK,temp.count);
        }

        public void addWord(String word){
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                // 查看当前字典树开始是否包含字符cur
                if (temp.next.get(cur) == null){
                    // 不包含的话
                    temp.next.put(cur,new Node());
                }
                // 包含的话，temp指针往下移动
                temp = temp.next.get(cur);
            }
            // 加入该单词之后，词频 ++
            temp.count ++;
        }

        // 获取单词word的词频
        public int getWordFrequency(String word){
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                // 在该题里这里是不可能走进这个if的，常规加一下
                if (temp.next.get(cur) == null){
                    return 0;
                }
                temp = temp.next.get(cur);
            }
            return temp.count;
        }
    }

    private void findMinAndReplace(int[] frequencyK,int newNum){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < frequencyK.length; i++) {
            if (frequencyK[i] < min){
                min = frequencyK[i];
                minIndex = i;
            }
        }
        if (newNum > min){
            frequencyK[minIndex] = newNum;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)){
                map.put(word,map.get(word) + 1);
            }else {
                map.put(word,1);
            }
        }
        List<String> collect = map.entrySet().stream().sorted((v1, v2) -> {
            // 这里面是排序，先以value词频进行降序排序
            if (v1.getValue() - v2.getValue() > 0) {
                return -1;
            } else if (v1.getValue() - v2.getValue() < 0) {
                return 1;
            } else {
                // 如果词频相等，那么以key的字典序进行排序
                if (v1.getKey().compareTo(v2.getKey()) > 0) {
                    return 1;
                } else if (v1.getKey().compareTo(v2.getKey()) < 0) {
                    return -1;
                }
                return 0;
            }
        }).map(Map.Entry::getKey).collect(Collectors.toList());
        return collect.subList(0,k);
    }

    @Test
    public void test(){
        Trie trie = new Trie();
        trie.addWord("asdfasf");
        trie.addWord("asdfasf");
        trie.addWord("asdfasf");
        trie.addWord("asdfasf");
        trie.addWord("as");
        System.out.println(trie.getWordFrequency("asdfasf"));
        System.out.println(trie.getWordFrequency("as"));
    }
}
