package com.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

// @lc code=start
class StockSpanner {
    Deque<Integer> q;
    List<Integer> list;
    public StockSpanner() {
        q = new ArrayDeque<>();
        list = new ArrayList<>();
    }
    // 左边第一个比自己大的，现在不一样的，自己不是候选人
    public int next(int price) {    
        while (!q.isEmpty() && list.get(q.peek()) <= price) {
            q.pop();
        }
        int span = q.isEmpty() ? list.size() : list.size() - q.peek() - 1;
        q.push(list.size());
        list.add(price);
        return span; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

