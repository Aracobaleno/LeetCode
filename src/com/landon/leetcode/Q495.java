package com.landon.leetcode;

public class Q495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonedDuration = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] < duration) {
                poisonedDuration += timeSeries[i] - timeSeries[i - 1];
            } else {
                poisonedDuration += duration;
            }
        }
        return poisonedDuration + duration;
    }

    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries.length == 1)
            return duration;
        int poisonedDuration = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            poisonedDuration += Math.min(timeSeries[i]- timeSeries[i - 1], duration);
        }
        return poisonedDuration + duration;
    }

    public int findPoisonedDuration3(int[] timeSeries, int duration) {
        int ans = 0;
        int last = -1; //上一次中毒结束位置
        for (int time : timeSeries) {
            int end = time + duration - 1;
            ans += last < time ? duration : end - last;
            last = end;
        }
        return ans;
    }
}
