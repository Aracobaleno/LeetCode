package com.landon.leetcode;

public class Q605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int insertable = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    insertable += i / 2;
                } else {
                    insertable += (i - prev -2) / 2;
                }
                if (insertable >= n)
                    return true;
                prev = i;
            }
        }
        if (prev < 0) {
            insertable += (m + 1) / 2;
        } else {
            insertable += (m - prev -1) / 2;
        }
        return insertable >= n;
    }
    //连续三个为零，可插入，单独考虑一个坑，两个边界
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int insertable = 0;
        int m = flowerbed.length;
        if (m == 1 && flowerbed[0] == 0)
            return 1 >= n;
        else if (m == 1 && flowerbed[0] == 1) {
            return 0 == n;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            insertable++;
        }
        int i = 1;
        while(i + 2 < m) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
                flowerbed[i + 1] = 1;
                insertable++;
            }
            i++;
        }
        if (flowerbed[m-2] == 0 && flowerbed[m - 1] == 0) {
            flowerbed[m - 1] = 1;
            insertable++;
        }
        return insertable >= n;
    }
    //当前位置为零，前一格为边界或零，后一格为边界或零
    public boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int insertable = 0;
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0 && (i == 0 ||flowerbed[i - 1] == 0) && (i == m - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                insertable++;
            }
        }
        return insertable >= n;
    }
    //跳格子
    public boolean canPlaceFlowers4(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for (int i = 0; i < m && n > 0;) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == m - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }
}
