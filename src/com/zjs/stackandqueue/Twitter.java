package com.zjs.stackandqueue;

import java.util.*;

/**
 * @ClassName Twitter
 * @Description 355. 设计推特 题目链接: https://leetcode-cn.com/problems/design-twitter/
 * 优先级队列
 * @Author hul-cyber
 * @Date 2021/2/26 9:25
 * @Version 1.0
 */
public class Twitter {

    // 时间
    private int time;
    // 用户列表
    private Map<Integer, User> users;

    // 用户类
    private class User {
        // 用户Id
        private int userId;
        // 关注者列表
        private List<User> followees;
        // 推文列表（以链表的形式组织起来）
        private Tweet lastestTweet;

        public User(int userId) {
            this.userId = userId;
            this.followees = new ArrayList<>();
            this.lastestTweet = null;
        }

        public List<User> getFollowees() {
            return followees;
        }

        public void addFollowee(User followee) {
            if (followee == null || this == followee || followees.contains(followee)) {
                return;
            }
            followees.add(followee);
        }

        public void removeFollowee(User followee) {
            if (followee == null) {
                return;
            }
            followees.remove(followee);
        }

        public void setLastestTweet(Tweet tweet) {
            lastestTweet = tweet;
        }

        public Tweet getLastestTweet() {
            return this.lastestTweet;
        }
    }

    // 推文类
    private class Tweet {
        // 推文Id
        private int tweetId;
        // 发布时间
        public int time;
        // 上一条推文
        private Tweet prevTweet;

        public Tweet (int tweetId, int time, Tweet tweet) {
            this.tweetId = tweetId;
            this.time = time;
            this.prevTweet = tweet;
        }

        public int getTweetId() {
            return this.tweetId;
        }

        public Tweet getPrevTweet() {
            return this.prevTweet;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        // 初始化时间为0
        time = 0;
        // 创建用户列表
        users = new HashMap<Integer, User>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // 通过userId查找用户，如果没有就创建用户
        User user = getOrCreateUser(userId);
        Tweet tweet = new Tweet(tweetId, time++, user.getLastestTweet());
        user.setLastestTweet(tweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // 获取关注列表
        User user = this.getOrCreateUser(userId);
        List<User> followees = user.getFollowees();
        int size = followees.size();
        Queue<Tweet> queue = new PriorityQueue<>(size + 1, Comparator.comparingInt((Tweet o) -> o.time).reversed());
        for (User followee : followees) {
            Tweet lastestTweet = followee.getLastestTweet();
            if (lastestTweet != null) {
                queue.offer(lastestTweet);
            }
        }
        if (user.getLastestTweet() != null) {
            queue.offer(user.getLastestTweet());
        }
        List<Integer> result = new ArrayList<>();
        while (result.size() < 10 && !queue.isEmpty()) {
            Tweet topTweet = queue.poll();
            result.add(topTweet.getTweetId());
            Tweet prevTweet = topTweet.getPrevTweet();
            if (prevTweet != null) {
                queue.offer(prevTweet);
            }
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = this.getOrCreateUser(followerId);
        User followee = this.getOrCreateUser(followeeId);
        follower.addFollowee(followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User follower = this.getOrCreateUser(followerId);
        User followee = this.getOrCreateUser(followeeId);
        follower.removeFollowee(followee);
    }

    // 查找或创建用户，最终返回用户
    private User getOrCreateUser(int userId) {
        if (users.get(userId) != null) {
            return users.get(userId);
        }
        // 如果没有，直接创建用户
        User user = new User(userId);
        users.put(userId, user);
        return user;
    }
}
