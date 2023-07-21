package com.landon.leetcode;

public class Q647 {
    //动态规划 tc：O(n^2), sc:O(n^2)
    public int countSubstrings(String s) {
        int cnt = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    cnt++;
                }
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Q647().countSubstrings("aaaaa"));
    }
    //中心扩散法 tc：O(n^2), sc:O(1)
    /*int cnt = 0;
    public int countSubstrings(String s) { //O(n^2)
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i); //奇数回文
            count(s, i, i+1); //偶数回文
        }
        return cnt;
    }
    public void count(String s, int i, int j){
//        while (s.charAt(i) == s.charAt(j) && i >= 0 && j < s.length()){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {//先判断下表是否越界，否则charAt会越界（利用短路）
            i--;
            j++;
            cnt++;
        }
    }*/
}
