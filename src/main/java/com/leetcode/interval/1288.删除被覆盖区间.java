package com.leetcode.interval;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1]; 
            }else {
                return i1[0] - i2[0];
            }
        });
        Arrays.asList(intervals).stream().forEach(i -> System.out.printf("[%d %d] ", i[0], i[1]));
        int leftEnd = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (leftEnd <= intervals[i][1]) {
                cnt = 1;
            }
            leftEnd = Math.max(leftEnd, intervals[i][1]);
        }
        return intervals.length - cnt;
    }
}
// @lc code=end

