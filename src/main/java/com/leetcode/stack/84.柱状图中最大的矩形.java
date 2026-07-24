package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 对于每一个柱子，都向左、右算第一个比其小的位置
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int[] left = new int[n];
        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i : i - stack.peek() - 1; // 左边有多少个比其小的
            stack.push(i);
            left[i] = span;
        }
        stack = new ArrayDeque<>();
        int[] right = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? n - 1 - i  : stack.peek() - i - 1; // 右边有多少个比其小的
            stack.push(i);
            right[i] = span;
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, (left[i] + right[i] + 1) * heights[i]);
        }
        return max;
    }
}
// @lc code=end
