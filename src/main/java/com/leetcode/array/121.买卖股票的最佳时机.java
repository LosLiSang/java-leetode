package com.leetcode.array;

/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int mini = 0;
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[mini] < prices[i]) {
                res = Math.max(res, prices[mini] - prices[i]);
            }else {
                mini = i;
            }
        }
        return res;
    }
}
// @lc code=end

