/*
Problem: Best Time to Buy and Sell Stock
Platform: LeetCode
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Approach:
Track minimum price so far and calculate maximum profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
