package com.landon.leetcode;

public class Q779 {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        if (parent == 0)
            return (k & 1) == 1 ? 0 : 1;
        else
            return (k & 1) == 1 ? 1 : 0;
    }
}
