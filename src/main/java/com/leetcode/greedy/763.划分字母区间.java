package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] appearIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            appearIndex[c - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, appearIndex[c - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
// @lc code=end

