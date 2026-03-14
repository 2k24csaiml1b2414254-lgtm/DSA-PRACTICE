/*
Problem: Rotate Array
Platform: LeetCode
Link: https://leetcode.com/problems/rotate-array/

--------------------------------------------------
Approach 1: Using Extra Array
--------------------------------------------------
Idea:
Create a temporary array and place the last k elements at the beginning,
then place the remaining elements.

Steps:
1. Store last k elements in a new array.
2. Store the remaining elements.
3. Copy the temporary array back to the original array.

Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];
        int a = 0;

        for(int i = n - k; i < n; i++){
            temp[a++] = nums[i];
        }

        for(int i = 0; i < n - k; i++){
            temp[a++] = nums[i];
        }

        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }
}

/*
Problem: Rotate Array
Platform: LeetCode
Link: https://leetcode.com/problems/rotate-array/

--------------------------------------------------
Approach 2: Reverse Algorithm (Optimal)
--------------------------------------------------
Idea:
Instead of using extra space, we reverse parts of the array.

Steps:
1. Reverse the entire array.
2. Reverse the first k elements.
3. Reverse the remaining n-k elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int start, int end){

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
