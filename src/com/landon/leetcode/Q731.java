package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q731 {
}

class MyCalendarTwo {
    //遍历
    /*List<int[]> booked;
    List<int[]> overlap;
    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlap = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : overlap) {
            if (arr[0] < end && start < arr[1])
                return false;
        }
        for (int[] arr : booked) {
            if (arr[0] < end && start < arr[1])
                overlap.add(new int[]{Math.max(arr[0], start), Math.min(arr[1], end)});
        }
        booked.add(new int[]{start, end});
        return true;
    }*/


}