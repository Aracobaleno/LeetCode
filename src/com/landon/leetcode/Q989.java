package com.landon.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> r = new LinkedList<>();
        int l = num.length - 1;
        while (l>=0 || k>0) {
            if(l >= 0) {
                k+=num[l];
            }
            r.addFirst(k%10);
            k/=10;
            l--;
        }
        return  r;
    }
}
