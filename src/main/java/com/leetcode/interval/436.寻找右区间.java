package com.leetcode.interval;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        // 1. 创建由start和idx组合的数组并排序
        int[][] idx = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            idx[i][0] = intervals[i][0];
            idx[i][1] = i;
        }
        Arrays.sort(idx, (i1, i2) -> i1[0] - i2[0]);

        // 2. 对每一个区间，利用start的有序性，二分查找第一个大与endi的start及其idx
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            // res[i] = Arrays.binarySearch(idx, intervals[i], (i1, i2) -> i1[0] - i2[0]);
            int left = 0, right = intervals.length - 1;
            int key = intervals[i][1];
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if(idx[mid][0] < key) {
                    left = mid + 1;
                }else {
                    ans = idx[mid][1];
                    right = mid - 1;
                }
            }
            res[i] = ans;
        }
        
        return res;

    }
}
// @lc code=end
