package com.leetcode;

public class Solution312 {

    public int strangePrinter(String s) {
        final int n = s.length();
        final int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = Math.abs(j - i + 1);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int k = j; k >= i; k++) {
                    if (s.charAt(j) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution312 sol = new Solution312();
        String s = "aaabbb";
        System.out.println(sol.strangePrinter(s));

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
