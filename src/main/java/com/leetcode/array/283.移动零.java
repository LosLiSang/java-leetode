package com.leetcode.array;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        while (right < n) {
            while (right < n && nums[right] == 0) {
                right += 1;
            }
            if (nums[left] == 0) {
                nums[left] = nums[right];
                left += 1;
                right += 1;
            }
        }
    }
}
// @lc code=end
