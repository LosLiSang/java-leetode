package com.leetcode.greedy;

public class Solution45 {

    // 开始跳跃，每一次选择当前能跳跃的，格子里面的最大的数，直到能跳出数组

    public int jump(int[] nums) {
        final int n = nums.length;
        int i = 0, end = nums[0], nextEnd = 0,cnt = 0;
        while (i < n - 1) {
            nextEnd = Math.max(end, i + nums[i]);
            if (i == end) {
                cnt += 1;
                end = nextEnd;
            }
            i += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution45 sol = new Solution45();
        // int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[] { 1, 2, 1, 1, 1 };
        // int[] nums = new int[]{2,1};
        int jump = sol.jump(nums);
        ;
        System.out.println(jump);
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
