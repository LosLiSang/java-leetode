package com.leetcode.greedy;

public class Solution2598 {

    public int findSmallestInteger(int[] nums, int value) {
        final int n = nums.length;
        int[] modCnt = new int[value];
        for (int i = 0; i < n; i++) {
            nums[i] = Math.floorMod(nums[i], value);
            modCnt[nums[i]] += 1;
        }
        int minIdx = value, minCnt = Integer.MAX_VALUE;
        for (int i = 0; i < value; i ++) {
            if (minCnt > modCnt[i]) {
                minIdx = i;
                minCnt = modCnt[i];
            }
        }
        
        return minCnt * value + minIdx;
    }


    public static void main(String[] args) {
        Solution2598 sol = new Solution2598();
        int[] nums = new int[]{1,-10,7,13,6,8};
        int value = 5;
        System.out.println(sol.findSmallestInteger(nums, value));
        
    }


    // Or use interactive testing with Scanner:
    /*
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);

        // Read input
        // Modify according to problem input format
        System.out.print("Enter array: ");
        String line = sc.nextLine();
        String[] parts = line.split("[,\\s]+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        // Run solution
        int[] result = sol.twoSum(nums, target);
        System.out.println("Output: " + java.util.Arrays.toString(result));

        sc.close();
    }
    */
}
