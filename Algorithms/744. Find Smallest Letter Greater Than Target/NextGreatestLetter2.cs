//Author: Tushar Jaiswal
//Creation Date: 07/01/2018

/*Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"*/

public class Solution {
    public char NextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.Length;
        
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            if(letters[mid] <= target)
            { low = mid + 1; }
            else
            { high = mid; }
        }
        return letters[low % letters.Length];
    }
}