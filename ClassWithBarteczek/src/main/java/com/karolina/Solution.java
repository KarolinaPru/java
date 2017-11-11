package com.karolina;

public class Solution {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int first = nums[i];
                int second = nums[j];

                if (first + second == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

