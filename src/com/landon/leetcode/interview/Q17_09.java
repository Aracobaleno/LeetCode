package com.landon.leetcode.interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q17_09 {
    //多路归并
    public int getKthMagicNumber(int k) {
        int[] res = new int[k + 1];
        res[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int idx = 2; idx < k + 1; idx++) {
            int a = res[p3] * 3, b = res[p5] * 5, c = res[p7] * 7;
            int min = Math.min(Math.min(a, b), c);
            if (min == a) p3++;
            if (min == b) p5++;
            if (min == c) p7++;
            res[idx] = min;
        }
        return res[k];
    }

    //优先队列（小顶堆）
    public int getKthMagicNumber2(int k) {
        int[] nums = new int[] {3, 5, 7};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> hashset = new HashSet<>();
        pq.add(1L);
        hashset.add(1L);
        while (!pq.isEmpty()) {
            long ans = pq.poll();
            if (--k == 0) return (int) ans;
            for (int num : nums) {
                if (!hashset.contains(ans * num)) {
                    pq.add(ans * num);
                    hashset.add(ans * num);
                }
            }
        }
        return -1;
    }
}

