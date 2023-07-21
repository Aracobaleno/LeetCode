package com.landon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q930 {
    //哈希 前缀和
    /*public int numSubarraysWithSum(int[] nums, int goal) {
        int[] hash = new int[60001];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        for (int num : nums) {
            ans += hash[num -  goal];
        }
    }*/
    /*public int numSubarraysWithSum(int[] nums, int goal) {
        int[] hash = new int[60001];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        hash[goal] = 1;
        for (int num : nums) {
            ans += hash[num];
            ++hash[num + goal];
        }
        return ans;
    }*/
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> hash = new HashMap<>();
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        hash.put(goal, 1);
        for (int num : nums) {
            ans += hash.getOrDefault(num, 0);
            hash.put(num + goal, hash.getOrDefault(num + goal, 0) + 1);
        }
        return ans;
    }


    //滑动窗口
    /*public int numSubarraysWithSum(int[] nums, int goal) {
        return 0;
    }*/

    public static void main(String[] args) {
        System.out.println(new Q930().numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
}
