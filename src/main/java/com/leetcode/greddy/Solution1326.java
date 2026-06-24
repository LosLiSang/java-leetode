package com.leetcode.greddy;

public class Solution1326 {

    public int minTaps(int n, int[] ranges) {
        int[] bucket = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int index = Math.max(0, i - ranges[i]);
            bucket[index] = Math.max(i + ranges[i], bucket[index]);
        }
        int end = 0, nextEnd = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            nextEnd = Math.max(bucket[i], nextEnd);
            if (i == nextEnd) {
                return -1;
            }
            if (i == end) {
                cnt += 1;
                end = nextEnd;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution1326 sol = new Solution1326();
        int[] range = new int[] { 3, 4, 1, 1, 0, 0 };
        int n = 5;
        System.out.println(sol.minTaps(n, range));
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
