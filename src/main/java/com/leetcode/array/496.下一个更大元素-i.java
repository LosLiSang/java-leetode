package com.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], -1);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                int key = stack.pop();
                if(map.containsKey(key)) {
                    map.put(key, nums2[i]);
                }
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length]; 
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
// @lc code=end

