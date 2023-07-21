package com.landon.leetcode;

import java.util.TreeSet;

public class Q729 {
}

class MyCalendar {
    TreeSet<int[]> events;
    public MyCalendar() {
        events = new TreeSet<>((a,b) -> {
            if (a[1] <= b[0])
                return -1;
            else if (a[0] >= b[1])
                return 1;
            else
                return 0;
        });
    }

    public boolean book(int start, int end) {
        int[] event = {start, end};
        return events.add(event);
    }
}
