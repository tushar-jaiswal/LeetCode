### Sliding Window O(n) Time and O(1) Space Solution

**Algorithm**
Here is my solution which utilizes a simple sliding window technique with start and end pointers. Both the pointers always move to the right.
It keeps track of the max and min elements in the current window. These max and min elements help in determining if a new element from the end can be used to increase the window size. If the new element itself is a new max/min element, we update the window size and the min/max elements accordingly.

**Complexity**
Each element in the array could be traversed at most 2 times (once by start  pointer and once by end pointer) leading to a runtime complexity of O(n). Its space complexity is optimal at O(1) as it only uses a few variables.

**Java Solution**
```
public int longestSubarray(int[] nums, int limit) {
	int min = nums[0];
	int max = nums[0];
	int maxLength = 0;
	int start = 0;
	int end = 0;

	while (end < nums.length) {
		if (nums[end] >= min && nums[end] <= max) {
			maxLength = Math.max(maxLength, end - start + 1);
			end++;
		} else if (nums[end] < min) {
			min = nums[end];
			for (int i = start; i <= end; i++) {
				max = Math.max(max, nums[i]);
				if (nums[i] - min > limit) {
					start = i + 1;
					max = nums[i + 1];
				}
			}
		} else {
			max = nums[end];
			for (int i = start; i <= end; i++) {
				min = Math.min(min, nums[i]);
				if (max - nums[i] > limit) {
					start = i + 1;
					min = nums[i + 1];
				}
			}
		}
	}

	return maxLength;
}
```
