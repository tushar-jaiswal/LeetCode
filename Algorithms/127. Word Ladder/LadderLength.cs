//Author: Tushar Jaiswal
//Creation Date: 09/22/2018

/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.*/

public class Solution {
    public int LadderLength(string beginWord, string endWord, IList<string> wordList) {
        HashSet<string> words = new HashSet<string>();
        foreach(string word in wordList)
        { words.Add(word); }
        if(!words.Contains(endWord))
        { return 0; }
        HashSet<string> visited = new HashSet<string>();
        Queue<string> queue = new Queue<string>();
        queue.Enqueue(beginWord);
        int length = 1;
        while(queue.Count != 0)
        {
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                string curr = queue.Dequeue();
                if(curr.Equals(endWord))
                { return length; }
                char[] word = curr.ToCharArray();
                for(int pos = 0; pos < word.Length; pos++)
                {
                    char originalChar = word[pos];
                    for(int j = 0; j < 26; j++)
                    {
                        char newChar = (char)('a' + j);
                        word[pos] = newChar;
                        string str = new string(word);
                        if(words.Contains(str) && !visited.Contains(str))
                        {
                            visited.Add(str);
                            queue.Enqueue(str);
                        }
                    }
                    word[pos] = originalChar;
                }
            }
            length++;
        }
        return 0;
    }
}