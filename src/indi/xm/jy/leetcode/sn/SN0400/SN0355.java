package indi.xm.jy.leetcode.sn.SN0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @ProjectName: leetcode
 * @Package: indi.xm.jy.leetcode.sn.SN0400
 * @ClassName: SN0355
 * @Author: albert.fang
 * @Description: 设计推特
 * @Date: 2021/9/3 14:12
 */
public class SN0355 {
    class Twitter {

        private Node contract;

        private int size;

        class Node{
            int userId;
            int tweetId;
            List<Integer> userIds = new ArrayList<>();
            Node next;

            public Node(int userId, int tweetId) {
                this.userId = userId;
                this.tweetId = tweetId;
            }

            public Node(int userId,Integer userId2){
                this.userId = userId;
                this.userIds.add(userId2);
            }

            public Node(){

            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getTweetId() {
                return tweetId;
            }

            public void setTweetId(int tweetId) {
                this.tweetId = tweetId;
            }

            public List<Integer> getUserIds() {
                return userIds;
            }

            public void setUserIds(List<Integer> userIds) {
                this.userIds = userIds;
            }
        }

        /** Initialize your data structure here. */
        public Twitter() {
            contract = new Node();
            size = 0;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Node dh = contract;
            for (int i = 0; i < size; i++) {
                dh = dh.next;
            }
            dh.next = new Node(userId,tweetId);
            size ++;
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            ArrayList<Integer> res = new ArrayList<>();
            Node dh = contract;
            // 保存当前userid 和 userid 的关注id
            TreeSet<Integer> set = new TreeSet<>();
            set.add(userId);
            while (dh != null){
                if (dh.getUserId() == userId){
                    set.addAll(dh.getUserIds());
                }
                dh = dh.next;
            }
            Node dummy = contract;
            while (dummy != null){
                if (set.contains(dummy.getUserId())){
                    if (dummy.getTweetId() != 0){
                        res.add(dummy.getTweetId());
                    }
                }
                dummy = dummy.next;
            }
            Collections.reverse(res);
            return res.size() >= 10 ? res.subList(0,10) : res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            Node dh = contract;
            // 是否存在 followerId true -> 存在；false -> 不存在
            boolean flag = false;
            while (dh != null){
                if (dh.getUserId() == followerId){
                    flag = true;
                    dh.getUserIds().add(followeeId);
                    break;
                }
                dh = dh.next;
            }
            if (!flag){
                Node dummy = contract;
                for (int i = 0; i < size; i++) {
                    dummy = dummy.next;
                }
                dummy.next = new Node(followerId,(Integer) followeeId);
                size ++;
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            Node dh = contract;
            while (dh != null){
                if (dh.getUserId() == followerId){
                    dh.getUserIds().remove((Integer) followeeId);
                    break;
                }
                dh = dh.next;
            }
        }
    }

    @Test
    public void test(){
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
    }
}
