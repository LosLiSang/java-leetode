package com.leetcode.stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                sum += Math.max(leftMax - height[left], 0);  
                leftMax = Math.max(leftMax, height[left]);
                left += 1;
            }else {
                sum += Math.max(rightMax - height[right], 0);  
                rightMax = Math.max(rightMax, height[right]);
                right += 1;
            }
        }
        return sum;
    }
}
// @lc code=end

