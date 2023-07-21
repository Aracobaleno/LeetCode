package com.landon.leetcode;

public class Q5 {
    //动态规划
    /*public String longestPalindrome(String s) {
        int len = s.length();
        int siteI = 0, siteJ = 0, maxLen = -1;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i > maxLen) {
                        maxLen = j - i;
                        siteI = i;
                        siteJ = j;
                    }
                }
            }
        }
        return s.substring(siteI, siteJ+1);
    }*/

    //中心扩散
    /*int left = 0, right = 0;
    int maxLen = -1;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            findPalindrome(s.toCharArray(), i, i);
            findPalindrome(s.toCharArray(), i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    public void findPalindrome(char[] chars, int i, int j) {
        while(i >= 0 && j < chars.length && chars[i] == chars[j]) {
            if (j - i > maxLen) {
                maxLen = j - i;
                left = i;
                right = j;
            }
            --i;
            ++j;
        }
    }*/

    //中心扩散优化
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Q5().longestPalindrome("aaaa"));
    }
}
