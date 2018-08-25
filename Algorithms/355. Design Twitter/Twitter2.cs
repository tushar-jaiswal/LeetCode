//Author: Tushar Jaiswal
//Creation Date: 08/25/2018

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

public class Twitter {
    Dictionary<int, List<int>> users;
    Dictionary<int, LinkedList<Tuple<int, int>>> userTweets;
    int count = 0;
    
    /** Initialize your data structure here. */
    public Twitter() {
        users = new Dictionary<int, List<int>>();
        userTweets = new Dictionary<int, LinkedList<Tuple<int, int>>>();
    }
    
    /** Compose a new tweet. */
    public void PostTweet(int userId, int tweetId) {
        if(!userTweets.ContainsKey(userId))
        {
            userTweets.Add(userId, new LinkedList<Tuple<int, int>>()); 
            Follow(userId, userId);
        }
        userTweets[userId].AddFirst(new Tuple<int, int>(count++, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public IList<int> GetNewsFeed(int userId) {
        List<int> topTweets = new List<int>();
        if(!users.ContainsKey(userId))
        { return topTweets;}
        List<int> followers = users[userId];
        SortedList<int, int> heap = new SortedList<int, int>(new DescComparer());
        foreach(int follower in followers)
        {
            int tweetCount = 0;
            if(userTweets.ContainsKey(follower))
            {
                foreach(Tuple<int, int> tweet in userTweets[follower])
                {
                    heap.Add(tweet.Item1, tweet.Item2);
                    tweetCount++;
                    if(tweetCount == 10)
                    { break; }
                }
            }
        }
        while(heap.Count != 0 && topTweets.Count < 10)
        {
            topTweets.Add(heap.Values[0]);
            heap.RemoveAt(0);
        }
        return topTweets;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void Follow(int followerId, int followeeId) {
        if(!users.ContainsKey(followerId))
        { users.Add(followerId, new List<int>()); }
        if(!users[followerId].Contains(followeeId))
        { users[followerId].Add(followeeId); }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void Unfollow(int followerId, int followeeId) {
        if(users.ContainsKey(followerId) && followerId != followeeId)
        { users[followerId].Remove(followeeId); }
    }
}

public class DescComparer : IComparer<int>
{
    public int Compare(int a, int b)
    {
        return b.CompareTo(a);
    }
} 

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.PostTweet(userId,tweetId);
 * IList<int> param_2 = obj.GetNewsFeed(userId);
 * obj.Follow(followerId,followeeId);
 * obj.Unfollow(followerId,followeeId);
 */