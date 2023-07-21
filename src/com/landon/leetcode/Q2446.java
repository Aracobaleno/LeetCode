package com.landon.leetcode;

public class Q2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        float[] e1 = new float[2], e2 = new float[2];
        int i = 0, j = 0;
        for (String s : event1) {
            e1[i++] = Float.parseFloat(s.replace(':', '.'));
        }

        for (String s : event2) {
            e2[j++] = Float.parseFloat(s.replace(':', '.'));
        }
        if (e1[1] >= e2[0] && e1[1] <= e2[1]) {
            return true;
        } else if (e2[1] >= e1[0] && e2[1] <= e1[1]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean haveConflict2(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
