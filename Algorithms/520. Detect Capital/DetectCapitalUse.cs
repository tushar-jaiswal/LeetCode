//Author: Tushar Jaiswal
//Creation Date: 06/18/2019

/*Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:
Input: "USA"
Output: True

Example 2:
Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.*/

public class Solution {
    public bool DetectCapitalUse(string word) {
        int capitalCharCount = 0;
        for(int i = 0; i < word.Length; i++)
        {
            if(word[i] >= 65 && word[i] <= 90)
            { capitalCharCount++; }
        }
        return (capitalCharCount == 0 || capitalCharCount == word.Length || (capitalCharCount == 1 && (word[0] >= 65 && word[0] <= 90))) ? true : false;
    }
}
