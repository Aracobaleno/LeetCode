package com.landon.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Q17_19 {

    //等差求和，求差值
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sn = (1 + n) * n / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int d = sn - sum;
        int boundary = d / 2;
        sum = 0;
        for (int i : nums) {
            if (i <= boundary) sum += i;
        }
        int res = (1 + boundary) * boundary / 2 - sum;
        return new int[]{res, d - res};
    }

    //异或，求出lowbit，及该位一个数为1，另一个为0，再异或找出该位为1的数
    public int[] missingTwo2(int[] nums) {
        int ans = 0;
        for (int i : nums) ans ^= i;
        for (int i = 1; i <= nums.length + 2; i++) ans ^= i; //两个消失数的异或值
        int diff = ans & (-ans); //找出最低为不同的地方（lowbit）
        int res = 0;
        for (int i : nums) {
            if ((diff & i) != 0) res ^= i;
        }
        for (int i = 1; i <= nums.length + 2; i++) {
            if ((diff & i) != 0) res ^= i;
        }
        return new int[] {res, ans ^ res}; //最低不同位为1，最低不同位为0
    }

    //原地hash
    public static int[] missingTwo3(int[] nums) {
        int[] res = new int[2];
        ArrayList<Integer> arr = new ArrayList<>();
        //Vector<Integer> v = new Vector<>();
        for (int i : nums) {
            arr.add(i);
        }
        for (int i = 0; i < 3; i++) {
            arr.add(-1);
        }
        for (int i = 0; i < arr.size(); i++) {
            while (i != arr.get(i) && arr.get(i) != -1) {
                int a = arr.get(i), idx = a, b = arr.get(idx);
                a ^= b;
                b ^= a;
                a ^= b;
                arr.set(i, a);
                arr.set(idx, b);
            }
        }
        int index = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) == -1)
                res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,6,3,1,2};
        System.out.println(missingTwo3(nums).toString());
    }
}
