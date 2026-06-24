package com.leetcode.greddy;

public class Solution55 {

    // 开始跳跃，每一次选择当前能跳跃的，格子里面的最大的数，直到能跳出数组

    public boolean canJump(int[] nums) {
        final int n = nums.length;
        int i = 0, end = 0;
        do {
            if(end >= n - 1) {
                return true;
            }
            end = Math.max(i + nums[i], end);
        }while(i++ != end);

        return false;

    }

    public static void main(String[] args) {
        Solution55 sol = new Solution55();
        // int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[] { 1, 2, 1, 1, 1 };
        // int[] nums = new int[]{2,1};
        System.out.println(sol.canJump(nums));
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
