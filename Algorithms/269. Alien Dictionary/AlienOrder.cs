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
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.*/

using System;
using System.Collections.Generic;

namespace ConsoleApp
{
    class AlienDictionary
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(AlienOrder(new string[] { "wrt", "wrf", "er", "ett", "rftt" }));
            Console.WriteLine(AlienOrder(new string[] { "z", "x" }));
            Console.WriteLine(AlienOrder(new string[] { "z", "x" , "z"}));
        }

        public static string AlienOrder(string[] words)
        {
            Dictionary<char, List<char>> graph = new Dictionary<char, List<char>>();
            Dictionary<char, int> inDegree = new Dictionary<char, int>();
            CreateGraph(words, graph, inDegree);
            string order = TopologicalSorting(graph, inDegree);
            return order.Length == graph.Count ? order : "";
        }

        private static void CreateGraph(string[] words, Dictionary<char, List<char>> graph, Dictionary<char, int> inDegree)
        {
            foreach (string word in words)
            {
                foreach (char c in word)
                {
                    if (!graph.ContainsKey(c))
                    { graph.Add(c, new List<char>()); }
                    if (!inDegree.ContainsKey(c))
                    { inDegree.Add(c, 0); }
                }
            }

            for (int i = 1; i < words.Length; i++)
            {
                string first = words[i - 1];
                string second = words[i];
                int minLength = Math.Min(first.Length, second.Length);

                for (int j = 0; j < minLength; j++)
                {
                    char parent = first[j];
                    char child = second[j];
                    if (parent != child)
                    {
                        graph[parent].Add(child);
                        inDegree[child]++;
                    }
                }
            }
        }

        private static string TopologicalSorting(Dictionary<char, List<char>> graph, Dictionary<char, int> inDegree)
        {
            Queue<char> queue = new Queue<char>();
            string order = "";

            foreach (KeyValuePair<char, int> kvp in inDegree)
            {
                if(kvp.Value == 0)
                { queue.Enqueue(kvp.Key); }
            }
            while(queue.Count != 0)
            {
                char c = queue.Dequeue();
                order += c;
                foreach(char child in graph[c])
                {
                    inDegree[child]--;
                    if(inDegree[child] == 0)
                    { queue.Enqueue(child); }
                }
            }
            return order;
        }
    }
}
