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
    LinkedList<Map.Entry<Integer, Integer>> tweets;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<Integer, List<Integer>>();
        tweets = new LinkedList<Map.Entry<Integer, Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId))
        { users.put(userId, new ArrayList<Integer>()); }
        tweets.addFirst(new java.util.AbstractMap.SimpleEntry<Integer, Integer>(userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> topTweets = new ArrayList<Integer>();
        if(!users.containsKey(userId))
        { return topTweets;}
        for(Map.Entry<Integer, Integer> tweet : tweets)
        {
            if(userId == tweet.getKey() || users.get(userId).contains(tweet.getKey()))
            { topTweets.add(tweet.getValue()); }
            if(topTweets.size() == 10)
            { break; }
        }
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

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */