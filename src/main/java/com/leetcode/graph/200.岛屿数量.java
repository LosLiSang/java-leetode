package com.leetcode.graph;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(char[][] grid, int x, int y, int rows, int cols) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y, rows, cols);
        dfs(grid, x - 1, y, rows, cols);
        dfs(grid, x, y + 1, rows, cols);
        dfs(grid, x, y - 1, rows, cols);
    }
}
// @lc code=end

