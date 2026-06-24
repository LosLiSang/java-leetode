package com.leetcode.array;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int cnt = 0;
        for(int i = 0; i < g.length && j < s.length; i++) {
            if (g[i] <= s[j]) {
                cnt += 1;
                j += 1;
            }
        }
        return cnt;
    }
}
// @lc code=end

