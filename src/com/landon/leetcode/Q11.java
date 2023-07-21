package com.landon.leetcode;

public class Q11 {
    //超出时间限制
    /*public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if(height[i]  > ans / (n-i-1)){ //优化（剪枝） 可通过
                for (int j = i + 1; j < n; j++) {
                    ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
                }
            }
        }
        return ans;
    }*/

    //双指针
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) ++l;
            else --r;
        }
        return ans;
    }
}
