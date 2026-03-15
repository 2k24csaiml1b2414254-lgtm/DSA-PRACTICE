/*
Problem: Single Number
Platform: LeetCode
Link: https://leetcode.com/problems/single-number/

Approach:
Use XOR bit manipulation.

Key Properties of XOR:
1. a ^ a = 0  (same numbers cancel out)
2. a ^ 0 = a
3. XOR is commutative and associative.

Since every element appears twice except one,
XOR of all elements will cancel the duplicates
and leave the single number.

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
