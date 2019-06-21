//Author: Tushar Jaiswal
//Creation Date: 06/21/2019

/*Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.*/

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<String>(wordList);
        HashMap<String, List<String>> neighbors = new HashMap<String, List<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        int shortestDistance = bfs(beginWord, endWord, words, neighbors, distance);
        List<List<String>> result = new ArrayList<List<String>>();
        if(shortestDistance != -1)
        { dfs(beginWord, endWord, neighbors, distance, shortestDistance, new ArrayList<String>(Arrays.asList(beginWord)), result); }
        return result;
    }

    private int bfs(String beginWord, String endWord, HashSet<String> words, HashMap<String, List<String>> neighbors, HashMap<String, Integer> distance)
    {
        if(!words.contains(endWord))
        { return -1; }
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int shortestDistance = 1;
        distance.put(beginWord, shortestDistance);
        boolean foundShortest = false;
        while(!queue.isEmpty() && !foundShortest)
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                String word = queue.poll();
                neighbors.put(word, getNeighbors(word, words));
                for(String neighbor : neighbors.get(word))
                {
                    if(!distance.containsKey(neighbor))
                    {
                        queue.offer(neighbor);
                        distance.put(neighbor, shortestDistance + 1);
                    }
                    if(neighbor.equals(endWord))
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

    private void dfs(String beginWord, String endWord, HashMap<String, List<String>> neighbors, HashMap<String, Integer> distance, int shortestDistance, List<String> curr, List<List<String>> result)
    {
        if(beginWord.equals(endWord))
        {
            result.add(curr);
            return;
        }
        if(curr.size() == shortestDistance)
        { return; }
        for(String neighbor : neighbors.get(beginWord))
        {
            if(distance.containsKey(neighbor) && distance.get(beginWord) + 1 == distance.get(neighbor))
            {
                List<String> newList = new ArrayList<String>(curr);
                newList.add(neighbor);
                dfs(neighbor, endWord, neighbors, distance, shortestDistance, newList, result);
            }
        }

    }

    private List<String> getNeighbors(String word, HashSet<String> words)
    {
        List<String> neighbors = new ArrayList<String>();
        char[] curr = word.toCharArray();
        for(int pos = 0; pos < curr.length; pos++)
        {
            char originalChar = curr[pos];
            for(int i = 0; i < 26; i++)
            {
                char c = (char)('a' + i);
                if(c != originalChar)
                {
                    curr[pos] = c;
                    String newWord = new String(curr);
                    if(words.contains(newWord))
                    {
                        neighbors.add(newWord);
                    }
                }
            }
            curr[pos] = originalChar;
        }
        return neighbors;
    }
}
