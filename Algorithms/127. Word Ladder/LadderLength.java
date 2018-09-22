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

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<String>();
        for(String word : wordList)
        { words.add(word); }
        if(!words.contains(endWord))
        { return 0; }
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int length = 1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                String curr = queue.poll();
                if(curr.equals(endWord))
                { return length; }
                char[] word = curr.toCharArray();
                for(int pos = 0; pos < word.length; pos++)
                {
                    char originalChar = word[pos];
                    for(int j = 0; j < 26; j++)
                    {
                        char newChar = (char)('a' + j);
                        word[pos] = newChar;
                        String str = new String(word);
                        if(words.contains(str) && !visited.contains(str))
                        {
                            visited.add(str);
                            queue.offer(str);
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