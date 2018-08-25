//Author: Tushar Jaiswal
//Creation Date: 08/24/2018

/*Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.

Example:
Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);*/

class Twitter {
    HashMap<Integer, List<Integer>> users;
    List<Tweet> tweets;
    int count = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<Integer, List<Integer>>();
        tweets = new ArrayList<Tweet>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId))
        { users.put(userId, new ArrayList<Integer>()); }
        tweets.add(new Tweet(userId, tweetId, count++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> topTweets = new ArrayList<Integer>();
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>();
        if(!users.containsKey(userId))
        { return topTweets;}
        for(Tweet tweet : tweets)
        {
            if(userId == tweet.user || users.get(userId).contains(tweet.user))
            { pq.offer(tweet); }
        }
        while(!pq.isEmpty() && topTweets.size() < 10)
        { topTweets.add(pq.poll().tweet); }
        return topTweets;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId))
        { users.put(followerId, new ArrayList<Integer>()); }
        users.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId))
        { users.get(followerId).remove((Integer)followeeId); }
    }
}

class Tweet implements Comparable<Tweet>
{
    int user;
    int tweet;
    int time;
    
    public Tweet(int userId, int tweetId, int time)
    {
        this.user = userId;
        this.tweet = tweetId;
        this.time = time;
    }
    
    @Override
    public int compareTo(Tweet b)
    {
        return b.time - this.time;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */