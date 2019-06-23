//Author: Tushar Jaiswal
//Creation Date: 06/23/2019

/*There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
Example 1:
Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,
[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,
[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty String.
There may be multiple valid order of letters, return any one of them is fine.*/

import java.util.*;

public class AlienDictionary {

	public static void main(String[] args) {
		System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		System.out.println(alienOrder(new String[] { "z", "x" }));
		System.out.println(alienOrder(new String[] { "z", "x" , "z"}));
	}

	public static String alienOrder(String[] words)
    {
        HashMap<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        HashMap<Character, Integer> inDegree = new HashMap<Character, Integer>();
        createGraph(words, graph, inDegree);
        String order = topologicalSorting(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    private static void createGraph(String[] words, HashMap<Character, List<Character>> graph, HashMap<Character, Integer> inDegree)
    {
        for (String word : words)
        {
            for (char c : word.toCharArray())
            {
                if (!graph.containsKey(c))
                { graph.put(c, new ArrayList<Character>()); }
                if (!inDegree.containsKey(c))
                { inDegree.put(c, 0); }
            }
        }

        for (int i = 1; i < words.length; i++)
        {
            String first = words[i - 1];
            String second = words[i];
            int minLength = Math.min(first.length(), second.length());

            for (int j = 0; j < minLength; j++)
            {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child)
                {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }
    }

    private static String topologicalSorting(HashMap<Character, List<Character>> graph, HashMap<Character, Integer> inDegree)
    {
        Queue<Character> queue = new LinkedList<Character>();
        String order = "";

        for (Map.Entry<Character, Integer> entry : inDegree.entrySet())
        {
            if(entry.getValue() == 0)
            { queue.offer(entry.getKey()); }
        }
        while(!queue.isEmpty())
        {
            char c = queue.poll();
            order += c;
            for(char child :graph.get(c))
            {
            	int degree = inDegree.get(child) - 1;
                inDegree.put(child, degree);
                if(degree == 0)
                { queue.offer(child); }
            }
        }
        return order;
    }
}
