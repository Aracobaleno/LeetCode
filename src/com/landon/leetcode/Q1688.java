package com.landon.leetcode;

public class Q1688 {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        String tmp = word;
        if (!sequence.contains(word)) return 0;
        else {
            while (sequence.contains(tmp)) {
                //sequence.replace(word, "");
                tmp += word;
                k++;
            }
        }
        return k;
    }

    /*public int maxRepeating2(String sequence, String word) {
        int k = 0;
        while (sequence.contains(word.repeat(k + 1))) {
            k++;
        }
        return k;
    }*/

    /*public int maxRepeating3(String sequence, String word) {
        for (int k = sequence.length() / word.length(); k > 0 ; k--) {
            if (sequence.contains(word.repeat(k))) {
                return k;
            }
        }
        return 0;
    }*/

    public int maxRepeating3(String sequence, String word) {
        int ans = 0;
        int m = sequence.length(), n = word.length();
        int p = 0;
        while (p < m) {
            if (sequence.charAt(p) == word.charAt(0)) {
                int i = p, j = 0, k = 0;
                while (i < m && sequence.charAt(i) == word.charAt(j)) {
                    i++;
                    if (j + 1 < n) {
                        j++;
                    } else {
                        j = 0;
                        k++;
                    }
                }
                ans = Math.max(k, ans);
            }
            p++;
        }
        return ans;
    }
}
