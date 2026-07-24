package com.leetcode.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=2406 lang=java
 *
 * [2406] 将区间分为最少组数
 */

// @lc code=start

class Solution {


    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();;
        int n = intervals.length;
        for(int i = 0; i < n; i++) {
            if (priorityQueue.size() == 0 || priorityQueue.peek() >= intervals[i][0] ) {
                priorityQueue.add(intervals[i][1]);
            }else {
                priorityQueue.poll();
                priorityQueue.add(intervals[i][1]);
            }

        }
        return priorityQueue.size();
    }


    public int minGroupsMethod1(int[][] intervals) {
        int[] diff = new int[1000000 + 1];
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            diff[left] += 1;
            diff[right + 1] -= 1;
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
// @lc code=end

