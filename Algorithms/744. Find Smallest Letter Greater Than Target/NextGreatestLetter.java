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

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1, mid = -1;
        
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if(letters[mid] == target)
            { 
                if(mid + 1 < letters.length && letters[mid + 1] == target)
                { low = mid + 1; }
                else
                { break; }
            }
            else if(letters[mid] > target)
            { high = mid - 1; }
            else if(mid + 1 < letters.length && letters[mid + 1] > target)
            { break; }
            else
            { low = mid + 1; }
        }
        if(high < 0)
        { return letters[0]; }
        if(mid == letters.length - 1)
        { return letters[0]; }
        return letters[mid + 1];
    }
}