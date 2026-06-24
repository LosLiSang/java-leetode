package com.leetcode.array;

import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            need.merge(t.charAt(i), 1, Integer::sum);

        }
        int left = 0, right = 0;
        String res = "";
        while (right < s.length()) {
            while (right < s.length() && valid < need.size()) {
                char c = s.charAt(right);
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                    valid += 1;
                }
                right += 1;
            }

            while (left < right && valid == need.size() ) {
                if (res.equals("") || res.length() > right - left) {
                    res = s.substring(left, right);
                }
                char c = s.charAt(left);
                if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                    valid -= 1;
                }
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left += 1;
            }
        }
        return res;
    }

}
// @lc code=end
