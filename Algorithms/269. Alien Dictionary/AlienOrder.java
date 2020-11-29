//Author: Tushar Jaiswal
//Creation Date: 11/28/2020

/*There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.

You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of this new language.

Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are multiple valid solutions, return any of them.

Example 1:
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"

Example 2:
Input: words = ["z","x"]
Output: "zx"

Example 3:
Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".

Constraints:
    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consists of only lowercase English letters.*/

/*Runtime Complexity: O(sum of lengths of all words)
Space Complexity: O(U + min(U^2,N)) where U is the total number of unique letters in the alien alphabet and N is the total number of strings in the input list.*/

class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 1) {
            return words[0];
        }

        var orderMap = new HashMap<Character, HashSet<Character>>();
        HashMap<Character, Integer> inDegreeMap = createInDegreeMap(words);

        for (int i = 0; i < words.length - 1; i++) {
            if (!compareWords(words[i], words[i + 1], orderMap, inDegreeMap)) {
                return "";
            }
        }

        String result = topologicalSorting(orderMap, inDegreeMap);
        int visitedCharsCount = result.length();
        int totalCharsCount = inDegreeMap.size();

        return visitedCharsCount == totalCharsCount ? result : "";
    }

    private HashMap<Character, Integer> createInDegreeMap(String[] words) {
        HashMap<Character, Integer> inDegreeMap = new HashMap<Character, Integer>();
        for (String word: words) {
            for (char c : word.toCharArray())
            inDegreeMap.put(c, 0);
        }

        return inDegreeMap;
    }

    private boolean compareWords(String word1, String word2, HashMap<Character, HashSet<Character>> orderMap, HashMap<Character, Integer> inDegreeMap) {
        int len1 = word1.length();
        int len2 = word2.length();
        boolean noCharDiff = true;

        int i = 0;
        for (; i < Math.min(len1, len2); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 != c2) {
                noCharDiff = false;
                if (!orderMap.containsKey(c1)) {
                    orderMap.put(c1, new HashSet<Character>());
                }
                if (!orderMap.get(c1).contains(c2)) {
                    orderMap.get(c1).add(c2);
                    inDegreeMap.merge(c2, 1, Integer::sum);
                }
                break;
            }
        }

        return len1 > len2 && noCharDiff ? false : true;
    }

    private String topologicalSorting(HashMap<Character, HashSet<Character>> orderMap, HashMap<Character, Integer> inDegreeMap) {
        var queue = new ArrayDeque<Character>();

        for (var entry : inDegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.remove();
            result.append(c);

            if (orderMap.containsKey(c)) {
                for (char child : orderMap.get(c)) {
                    inDegreeMap.merge(child, -1, Integer::sum);
                    if (inDegreeMap.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }
        }

        return result.toString();
    }
}
