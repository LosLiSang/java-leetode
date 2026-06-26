package com.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            switch (c) {
                case '(' -> q.push(c);
                case '{' -> q.push(c);
                case '[' -> q.push(c);
                case ')' -> {
                    if (q.isEmpty() || q.pop() != '(') return false;
                }
                case '}' -> {
                    if (q.isEmpty() || q.pop() != '{') return false;
                }
                case ']' -> {
                    if (q.isEmpty() || q.pop() != '[') return false;
                }
            }
        }
        return q.isEmpty();
    }
}
// @lc code=end

