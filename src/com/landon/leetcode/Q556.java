package com.landon.leetcode;

public class Q556 {
    //下一个排列（双指针）
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i < 0) return -1;
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j])
            j--;
        swap(nums, i, j);
        reverse(nums, i + 1);
        long l = Long.parseLong(new String(nums));
        return l > Integer.MAX_VALUE ? -1 : (int) l;
    }

    public void reverse(char[] nums, int begin) {
        int end = nums.length - 1;
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }
    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //下一个排列（数学）
    /*public int nextGreaterElement(int n) {
        return 1;
    }*/
    public static void main(String[] args) {
        System.out.println(new Q556().nextGreaterElement(2147483486));
    }
}
