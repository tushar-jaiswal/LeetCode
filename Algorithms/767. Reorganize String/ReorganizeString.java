//Author: Tushar Jaiswal
//Creation Date: 08/19/2018

/*Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
If possible, output any possible result.  If not possible, return the empty string.

Example 1:
Input: S = "aab"
Output: "aba"

Example 2:
Input: S = "aaab"
Output: ""

Note: S will consist of lowercase letters and have length in range [1, 500].*/

class Solution {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : S.toCharArray())
        { map.put(c, map.getOrDefault(c, 0) + 1); }
        
        PriorityQueue<Element> pQueue = new PriorityQueue<Element>();
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        { pQueue.offer(new Element(entry.getKey(), entry.getValue())); }
        
        StringBuilder sb = new StringBuilder();
        while(pQueue.size() > 0)
        {
            Element a = pQueue.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != a.val)
            {
                sb.append(a.val);
                a.frequency--;
                if(a.frequency > 0)
                { pQueue.offer(a); }
            }
            else if(pQueue.size() > 0)
            {
                Element b = pQueue.poll();
                sb.append(b.val);
                b.frequency--;
                if(b.frequency > 0)
                { pQueue.offer(b); }
                pQueue.offer(a);
            }
            else
            { return ""; }
        }
        return sb.toString();
    }
}

class Element implements Comparable<Element>
{
    char val;
    int frequency;
    
    public Element(char c, int freq)
    {
        val = c;
        frequency = freq;
    }
    
    public int compareTo(Element e)
    {
        return e.frequency - this.frequency;
    }
}