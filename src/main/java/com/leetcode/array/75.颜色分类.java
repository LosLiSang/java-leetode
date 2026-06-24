package com.leetcode.array;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left += 1;
                i += 1;
            }else if (nums[i] == 1) {
                i += 1;
            }
            else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right -= 1;
            }
        }
    }
}
// @lc code=end

