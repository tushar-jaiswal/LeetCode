//Author: Tushar Jaiswal
//Creation Date: 09/16/2018

/*Shuffle a set of numbers without duplicates.
Example:
// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();*/

public class Solution {
    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        rnd = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] Reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] Shuffle() {
        int[] shuffled = new int[nums.Length];
        Array.Copy(nums, 0, shuffled, 0, nums.Length);
        for(int i = 0; i < shuffled.Length; i++)
        {
            int rand = rnd.Next(i, shuffled.Length);
            Swap(shuffled, i, rand);
        }
        return shuffled;
    }
    
    public void Swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.Reset();
 * int[] param_2 = obj.Shuffle();
 */