package com.leetcode.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        final int n = stations.length;

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        int fuel = startFuel, i = 0, count = 0;
        while (fuel < target) {
            while (i < n && stations[i][0] <= fuel) {
                q.add(stations[i][1]);
                i += 1;
            }
            if (q.isEmpty()) {
                return -1;
            }
            count += 1;
            fuel += q.poll();
        }
        return count;
    }

    public static void main(String[] args) {
        int target = 100;
        int startFuel = 50;
        // int[][] statations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        // int[][] statations = new int[][] { { 25, 25 }, { 50, 50 } };
        int[][] statations = new int[][] { { 60,50 } };

        int res = new Solution871().minRefuelStops(target, startFuel, statations);
        System.out.println(res);
    }

}
