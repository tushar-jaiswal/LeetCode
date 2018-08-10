//Author: Tushar Jaiswal
//Creation Date: 08/09/2018

/*In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000*/

public class Solution {
    public string ReplaceWords(IList<string> dict, string sentence) {
        HashSet<string> hs = new HashSet<string>();
        foreach(string str in dict)
        { hs.Add(str); }
        
        StringBuilder sb = new StringBuilder();
        string[] words = sentence.Split(new char[]{' '}, StringSplitOptions.RemoveEmptyEntries);
        
        string prefix = "";
        foreach(string str in words)
        { 
            sb.Append(prefix);
            prefix = " ";
            string word = "";
            for(int i = 1; i <= str.Length; i++)
            {
                word = str.Substring(0, i);
                if(hs.Contains(word))
                { break; }
            }
            sb.Append(word);
        }
        return sb.ToString();
    }
}