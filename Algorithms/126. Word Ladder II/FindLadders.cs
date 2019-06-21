//Author: Tushar Jaiswal
//Creation Date: 06/13/2019

/*Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return an empty list if there is no such transformation sequence.
All words have the same Length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
InAdd:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
OutAdd:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
InAdd:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
OutAdd: []
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.*/

public class Solution {
    public IList<IList<string>> FindLadders(string beginWord, string endWord, IList<string> wordList) {
        HashSet<string> words = new HashSet<string>(wordList);
        Dictionary<string, List<string>> neighbors = new Dictionary<string, List<string>>();
        Dictionary<string, int> distance = new Dictionary<string, int>();
        int shortestDistance = bfs(beginWord, endWord, words, neighbors, distance);
        IList<IList<string>> result = new List<IList<string>>();
        if(shortestDistance != -1)
        { dfs(beginWord, endWord, neighbors, distance, shortestDistance, new List<string>(){beginWord}, result); }
        return result;
    }

    private int bfs(string beginWord, string endWord, HashSet<string> words, Dictionary<string, List<string>> neighbors, Dictionary<string, int> distance)
    {
        if(!words.Contains(endWord))
        { return -1; }
        Queue<string> queue = new Queue<string>();
        queue.Enqueue(beginWord);
        int shortestDistance = 1;
        distance.Add(beginWord, shortestDistance);
        bool foundShortest = false;
        while(queue.Count != 0 && !foundShortest)
        {
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                string word = queue.Dequeue();
                neighbors.Add(word, getNeighbors(word, words));
                foreach(string neighbor in neighbors[word])
                {
                    if(!distance.ContainsKey(neighbor))
                    {
                        queue.Enqueue(neighbor);
                        distance.Add(neighbor, shortestDistance + 1);
                    }
                    if(neighbor.Equals(endWord))
                    {
                        foundShortest = true;
                        break;
                    }
                }
            }
            shortestDistance++;
        }
        return foundShortest == true ? shortestDistance : -1;
    }

    private void dfs(string beginWord, string endWord, Dictionary<string, List<string>> neighbors, Dictionary<string, int> distance, int shortestDistance, List<string> curr, IList<IList<string>> result)
    {
        if(beginWord.Equals(endWord))
        {
            result.Add(curr);
            return;
        }
        if(curr.Count == shortestDistance)
        { return; }
        foreach(string neighbor in neighbors[beginWord])
        {
            if(distance.ContainsKey(neighbor) && distance[beginWord] + 1 == distance[neighbor])
            {
                List<string> newList = new List<string>(curr);
                newList.Add(neighbor);
                dfs(neighbor, endWord, neighbors, distance, shortestDistance, newList, result);
            }
        }

    }

    private List<string> getNeighbors(string word, HashSet<string> words)
    {
        List<string> neighbors = new List<string>();
        char[] curr = word.ToCharArray();
        for(int pos = 0; pos < curr.Length; pos++)
        {
            char originalChar = curr[pos];
            for(int i = 0; i < 26; i++)
            {
                char c = (char)('a' + i);
                if(c != originalChar)
                {
                    curr[pos] = c;
                    string newWord = new string(curr);
                    if(words.Contains(newWord))
                    {
                        neighbors.Add(newWord);
                    }
                }
            }
            curr[pos] = originalChar;
        }
        return neighbors;
    }
}
