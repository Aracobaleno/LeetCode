package com.landon.leetcode;

public class Q769 {
    //wrong!!!
    public int maxChunksToSorted(int[] arr) {
        int i = 1, count = 0, n = arr.length;
        if (n == 1) return 1;
        if (arr[0] == 0) count++;
        while (i < n) {
            if (arr[i - 1] > arr[i]) {
                while (i < n && arr[i - 1] > arr[i]) i++;
                count++;
            } else if (arr[i] - arr[i - 1] == 1) {
                i++;
                count++;
            }
        }
        return count;
    }

    public int maxChunksToSorted2(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Q769().maxChunksToSorted(new int[]{4,3,2,1,0}));
    }
}
