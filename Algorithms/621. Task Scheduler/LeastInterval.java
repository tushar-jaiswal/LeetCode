//Author: Tushar Jaiswal
//Creation Date: 01/17/2021

/*Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.

Example 2:
Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.

Example 3:
Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation:
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A

Constraints:
    1 <= task.length <= 104
    tasks[i] is upper-case English letter.
    The integer n is in the range [0, 100].
*/

/*Runtime Complexity: O(number of tasks)
Space Complexity: O(number of unique tasks)*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFrequency = 0;
        int numMaxFrequencyTasks = 0;
        var taskFrequencyMap = new HashMap<Character, Integer>();

        for (char task : tasks) {
            taskFrequencyMap.merge(task, 1, Integer::sum);
            int frequency = taskFrequencyMap.get(task);

            if (frequency == maxFrequency) {
                numMaxFrequencyTasks++;
            } else if (frequency > maxFrequency) {
                maxFrequency = frequency;
                numMaxFrequencyTasks = 1;
            }
        }

        // There are two cases
        // 1. The most frequent task is not frequent enough to force the presence of idle slots.
        // Cooling period 2 with tasks [A,B,C,D,E,A,F,A] results in [ABC,ADE,AF]
        // In this case, the total number of slots is defined by the length of tasks.
        // 2. The most frequent task is frequent enough to force some idle slots.
        // Cooling period 2 with tasks [A,B,C,D,B,A,B,A,A,B] results in [ABC,ABD,AB_,AB]
        // There are (maxFrequency - 1) groups with cooling periods. The length of these groups includes
        // 1 slot for the most frequent task execution and n for the idle slots which may get filled,
        // giving us (1+n) length of each such group. Total length of such groups is (maxFrequency - 1)*(1 + n).
        // After these groups, we will still have 1 instances of all tasks with the maxFrequency.
        // For this case, the total number of slots is: (maxFrequency - 1)*(1 + n) + numMaxFrequencyTasks
        // The answer is the maximum of these two cases.

        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + numMaxFrequencyTasks);
    }
}
