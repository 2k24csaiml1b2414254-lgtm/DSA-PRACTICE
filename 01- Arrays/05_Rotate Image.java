/*
Problem: Rotate Image
Platform: LeetCode
Link: https://leetcode.com/problems/rotate-image/

--------------------------------------------------
Approach 1: Transpose + Reverse (Optimal)
--------------------------------------------------
Idea:
To rotate the matrix 90 degrees clockwise without using extra space.

Steps:
1. Transpose the matrix
   (swap matrix[i][j] with matrix[j][i])
2. Reverse each row of the matrix

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose matrix
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < n; i++){

            int start = 0;
            int end = n - 1;

            while(start < end){

                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;

            }
        }
    }
}


/*
Problem: Rotate Image
Platform: LeetCode
Link: https://leetcode.com/problems/rotate-image/

--------------------------------------------------
Approach 2: Four Cell Cycle (Layer Rotation)
--------------------------------------------------
Idea:
Rotate the matrix layer by layer.
Each rotation moves four elements at a time.

Cycle Movement:
top → right
right → bottom
bottom → left
left → top

Steps:
1. Traverse matrix layer by layer.
2. For each element, rotate 4 elements in a cycle.

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for(int i = 0; i < n/2; i++){

            for(int j = i; j < n - i - 1; j++){

                int temp = matrix[i][j];

                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;

            }
        }
    }
}
