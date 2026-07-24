package com.leetcode.interval;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            if (a1 <= b2 && a2 >= b1) {
                res.add(new int[] {Math.max(a1, b1), Math.min(a2, b2)});
            }

            if(a2 < b2) {
                i++;
            }else {
                j++;
            }

        }
        return res.toArray(new int[0][]);
    }
}
// @lc code=end
