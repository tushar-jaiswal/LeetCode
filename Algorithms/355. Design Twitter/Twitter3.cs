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
    Dictionary<int, User> users;
    int count = 0;
    
    /** Initialize your data structure here. */
    public Twitter() {
        users = new Dictionary<int, User>();
    }
    
    /** Compose a new tweet. */
    public void PostTweet(int userId, int tweetId) {
        GetOrCreateUser(userId).PostTweet(tweetId, count++);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public IList<int> GetNewsFeed(int userId) {
        List<int> topTweets = new List<int>();
        if(!users.ContainsKey(userId))
        { return topTweets;}
        List<int> followers = users[userId].followers;
        SortedSet<Tweet> heap = new SortedSet<Tweet>(new DescComparer());
        foreach(int follower in followers)
        {
            if(users[follower].tweetHead != null)
            {
                heap.Add(users[follower].tweetHead);
            }
        }
        
        while(heap.Count != 0 && topTweets.Count < 10)
        {
            Tweet tweet = heap.First();
            topTweets.Add(tweet.tweetId);
            heap.Remove(heap.First());
            if(tweet.next != null)
            { heap.Add(tweet.next); }
        }
        return topTweets;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void Follow(int followerId, int followeeId) {
        GetOrCreateUser(followerId).Follow(followeeId);
        GetOrCreateUser(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void Unfollow(int followerId, int followeeId) {
        if(users.ContainsKey(followerId))
        { users[followerId].Unfollow(followeeId); }
    }
    
    private User GetOrCreateUser(int userId)
    {
        User user;
        if(!users.ContainsKey(userId))
        { 
            user = new User(userId);
            users.Add(userId, user); 
        }
        else
        { user = users[userId]; }
        return user;
    }
}

public class User
{
    int id;
    public Tweet tweetHead;
    public List<int> followers;
    
    public User(int id)
    {
        this.id = id;
        followers = new List<int>();
        Follow(id);
    }
    
    public void Follow(int id)
    {
        if(!followers.Contains(id))
        { followers.Add(id); }
    }
    
    public void Unfollow(int id)
    {
        if(this.id != id)
        { followers.Remove(id); }
    }
    
    public void PostTweet(int id, int time)
    {
        Tweet tweet = new Tweet(id, time);
        tweet.next = tweetHead;
        tweetHead = tweet;
    }
} 

public class Tweet
{
    public int tweetId;
    public int time;
    public Tweet next; 
    
    public Tweet(int tweetId, int time)
    {
        this.tweetId = tweetId;
        this.time = time;
        next = null;
    }
}

public class DescComparer : IComparer<Tweet>
{
    public int Compare(Tweet a, Tweet b)
    {
        return b.time.CompareTo(a.time);
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