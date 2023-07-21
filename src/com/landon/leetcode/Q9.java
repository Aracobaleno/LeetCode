package com.landon.leetcode;

public class Q9 {
    //数学解法
    /*public boolean isPalindrome(int x) {
        if (x < 0) {return false;}
        if (x == 0) {return true;}
        int reverseNum = 0, temp = x;
        while (x != 0) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        if (temp == reverseNum) {
            return true;
        }else {
            return false;
        }
    }*/

    //string解法
    /*public boolean isPalindrome(int x) {
        //三种方法效率依次递减
        StringBuilder s = new StringBuilder(Integer.toString(x)).reverse();
//        String s = String.valueOf(x);
//        String s = "" + x;
        return s.equals(new StringBuilder(Integer.toString(x)));
    }*/

    //遍历一半即可
    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {return true;}
        if (x < 0 || x % 10 == 0) {return false;}
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        return x == reverseNum || x == reverseNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(new Q9().isPalindrome(11));
    }
}
