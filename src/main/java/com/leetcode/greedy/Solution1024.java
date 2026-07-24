package com.leetcode.greedy;

public class Solution1024 {

    public int videoStitching(int[][] clips, int time) {
        int[] clip = new int[time + 1];
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] <= time) {
                clip[clips[i][0]] = Math.max(clip[clips[i][0]], clips[i][1]);
            }

        }
        int end = 0, nextEnd = 0, cnt = 0;
        for (int i = 0; i < time; i++) {
            nextEnd = Math.max(nextEnd, clip[i]);
            if(i == nextEnd) return -1;
            if(i == end) {
                cnt += 1;
                end = nextEnd;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution1024 sol = new Solution1024();
        int[][] clips = new int[][] {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int time = 10;
        System.out.println(sol.videoStitching(clips, time));
    }

    // Or use interactive testing with Scanner:
    /*
     * public static void main(String[] args) {
     * Solution sol = new Solution();
     * Scanner sc = new Scanner(System.in);
     * 
     * // Read input
     * // Modify according to problem input format
     * System.out.print("Enter array: ");
     * String line = sc.nextLine();
     * String[] parts = line.split("[,\\s]+");
     * int[] nums = new int[parts.length];
     * for (int i = 0; i < parts.length; i++) {
     * nums[i] = Integer.parseInt(parts[i]);
     * }
     * 
     * System.out.print("Enter target: ");
     * int target = sc.nextInt();
     * 
     * // Run solution
     * int[] result = sol.twoSum(nums, target);
     * System.out.println("Output: " + java.util.Arrays.toString(result));
     * 
     * sc.close();
     * }
     */
}
