package com.leetcode.slidingwindow;

import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int res = 0;
        HashSet<Object> set = new HashSet<>();
        for (int right = 0; right < n; right += 1) {
            if (set.contains(s.charAt(right))) {
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left += 1;
                }
                set.remove(s.charAt(left));
                left += 1;

            }
            set.add(s.charAt(right));

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
// @lc code=end

