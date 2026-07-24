package com.leetcode.greedy;

/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int cur = 0, bestStep = 0, steps = 0, farthest = 0;
        while(cur < nums.length - 1) {

            if (cur + nums[cur] >= nums.length - 1) {
                return steps + 1;
            }

            for(int i = cur; i <= cur + nums[cur]; i++) {
                if (farthest < i + nums[i]) {
                    bestStep = i;
                    farthest = i + nums[i];
                }
            }
            steps += 1;
            cur = bestStep;
        }
        return steps;
    }
}
// @lc code=end

