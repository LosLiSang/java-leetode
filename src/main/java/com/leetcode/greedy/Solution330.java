package com.leetcode.greedy;

public class Solution330 {

    public int minPatches(int[] nums, int n) {
        final int len = nums.length;
        long miss = 1;
        int i = 0, cnt = 0;
        while (miss <= n) {
            if (i < len && nums[i] <= miss) {
                miss += nums[i];
                i += 1;
            }else {
                cnt += 1;
                miss *= 2;
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        Solution330 sol = new Solution330();
        int[] nums = new int[] {1,3};
        int n = 10;
        int res = sol.minPatches(nums, n);
        System.out.println(res);
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
