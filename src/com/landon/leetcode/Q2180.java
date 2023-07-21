package com.landon.leetcode;

public class Q2180 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0, j = i;
            while (j != 0) {
                sum += j % 10;
                j /= 10;
            }
            if ((sum & 1) == 0)
                ans++;
        }
        return ans;
    }

    public int countEven2(int num) {
        int ans = num / 10 * 5 - 1;
        int sum = 0;
        for (int i = num / 10; i > 0; i /= 10) {
            sum += i % 10;
        }
        /*if ((sum & 1) == 0) {
            ans += num % 10 / 2 + 1;
        }else {
            ans += (num % 10 + 1) / 2;
        }*/
        ans += (num % 10 + 2 - (sum & 1)) / 2;
        return ans;
    }

    public int countEven3(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10) {
            sum += i % 10;
        }
        return (sum & 1) == 0 ? num / 2 : --num / 2;
    }
}
