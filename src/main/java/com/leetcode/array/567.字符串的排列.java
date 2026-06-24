package com.leetcode.array;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int[] need = new int[26];
        while (right < s1.length()) {
            need[s1.charAt(right) - 'a'] += 1;
            need[s2.charAt(right) - 'a'] -= 1;
            right += 1;
        }
        if (Arrays.stream(need).allMatch((int x) -> x == 0)) {
            return true;
        }
        while (right < s2.length()) {
            need[s2.charAt(left) - 'a'] += 1;
            need[s2.charAt(right) - 'a'] -= 1;
            if (Arrays.stream(need).allMatch((int x) -> x == 0)) {
                return true;
            }
            left += 1;
            right += 1;

        }
        return false;
    }
}
// @lc code=end
