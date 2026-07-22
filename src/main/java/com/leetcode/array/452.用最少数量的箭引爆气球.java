package com.leetcode.array;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
        int lastShot = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (lastShot < points[i][0]) { // 无法引爆
                cnt += 1;
                lastShot = points[i][1];
            }
        }
        return cnt;
    }
}
// @lc code=end

