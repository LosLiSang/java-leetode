package com.leetcode.array;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i2[1] - i1[1]);
        System.out.println();
        int curFar = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (curFar <= intervals[i][0] ) {
                curFar = intervals[i][1];
                cnt += 1;
            }
        }
        return intervals.length - cnt;
    }
}
// @lc code=end

