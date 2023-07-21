package com.landon.leetcode;

import java.util.TreeSet;

public class Q414 {
    //TreeSet排序，去重
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3)
                treeSet.remove(treeSet.first());
        }
        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }

    //遍历，维护最大三个数 a, b, c
    public int thirdMax1(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (num < a && num > b) {
                c = b;
                b = num;
            } else if (num < b && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    //遍历，维护最大三个数 a, b, c(初始化为空对象)
    public int thirdMax2(int[] nums) {
        Integer a = null, b = null, c = null;
        for (int num : nums) {
            if (a == null || num > a) {
                c = b;
                b = a;
                a = num;
            } else if (num < a && (b == null || num > b)) {
                c = b;
                b = num;
            //(b != null)这个条件防止 b, c还为空时，值等于a造成呢个空指针异常 测试用例2,2,3,1
            } else if (b != null && num < b && (c == null || num > c)) {
                c = num;
            }
        }
        return c == null ? a : c;
    }
}