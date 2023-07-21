package com.landon.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

public class Q03 {
    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[nums.length];
        for (int num : nums) {
            if (hash[num]++ == 1) {
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            if (!hash.add(num))
                return num;
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            if (nums[i] == nums[nums[i]]) return nums[i];
            else {
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
                i--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q03().findRepeatNumber3(new int[]{3, 4, 2, 0, 0, 1}));
    }
}
