package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26], base = new int[26];
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int l = 0;

        for(int r = 0; r < p.length(); r++) {
            freq[s.charAt(r) - 'a'] += 1;
            base[p.charAt(r) - 'a'] += 1;
        }
        if (Arrays.equals(freq, base)) {
            res.add(l);
        }
        for(int r = p.length(); r < s.length(); r++) {

            freq[s.charAt(l) - 'a'] -= 1;
            freq[s.charAt(r) - 'a'] += 1;
            l += 1;
            if (Arrays.equals(freq, base)) {
                res.add(l);
            }
        }
        return res;
    }
}
// @lc code=end

