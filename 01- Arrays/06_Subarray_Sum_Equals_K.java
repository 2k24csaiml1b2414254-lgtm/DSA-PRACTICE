/*
Problem: Subarray Sum Equals K
Platform: LeetCode
Link: https://leetcode.com/problems/subarray-sum-equals-k/

Approach 1: Brute Force

Idea:
Fix a starting index and keep adding elements to form subarrays.
Check for each subarray if the sum equals k.

Steps:
1. Start from index i
2. Keep adding elements till j
3. If sum == k → increment count

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

/*
Approach 2: Prefix Sum + HashMap

Idea:
If (current_sum - k) exists in map, then a subarray with sum k exists.

Why?
prefixSum[j] - prefixSum[i] = k
=> prefixSum[i] = prefixSum[j] - k

Steps:
1. Maintain running sum (prefix sum)
2. Check if (sum - k) exists in map
3. If yes → add its frequency to count
4. Store/update current sum in map

Important:
Initialize map with (0 → 1) to handle exact k cases from start

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        // Base case
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
