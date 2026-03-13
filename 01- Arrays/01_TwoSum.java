/*
Problem: Two Sum
Platform: LeetCode
Link: https://leetcode.com/problems/two-sum/

Approach:
Use HashMap to store visited numbers and their indices.

Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[2];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                idx1 = map.get(complement);
                idx2 = i;
                array[0] = idx1;
                array[1] = idx2;
                return array;
            }
            map.put(nums[i], i);
        }
        return array;
    }

}
