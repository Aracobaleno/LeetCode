package com.landon.leetcode;

import java.util.Arrays;

public class Q593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //四边相等，对角线相等
        int[] edge = {
                dist(p1, p2),
                dist(p1, p3),
                dist(p1, p4),
                dist(p2, p3),
                dist(p2, p4),
                dist(p3, p4)
        };
        Arrays.sort(edge);
        if (edge[0] != 0 && edge[0] == edge[1] && edge[0] == edge[2] && edge[0] == edge[3] && edge[4] == edge[5])
            return true;
        return false;
    }

    public int dist(int[] p1, int[] p2) {
        return (p2[0]-p1[0])*(p2[0]-p1[0]) + (p2[1]-p1[1])*(p2[1]-p1[1]);
    }
}
