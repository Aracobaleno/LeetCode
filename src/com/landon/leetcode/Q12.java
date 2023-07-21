package com.landon.leetcode;

public class Q12 {
    //swtich
    /*public String getTString(int thousand) {
        switch (thousand) {
            case 1: return "M";
            case 2: return "MM";
            case 3: return "MMM";
        }
        return "";
    }
    public String getHString(int hundred) {
        switch (hundred) {
            case 1: return "C";
            case 2: return "CC";
            case 3: return "CCC";
            case 4: return "CD";
            case 5: return "D";
            case 6: return "DC";
            case 7: return "DCC";
            case 8: return "DCCC";
            case 9: return "CM";
        }
        return "";
    }
    public String getTenString(int ten) {
        switch (ten) {
            case 1: return "X";
            case 2: return "XX";
            case 3: return "XXX";
            case 4: return "XL";
            case 5: return "L";
            case 6: return "LX";
            case 7: return "LXX";
            case 8: return "LXXX";
            case 9: return "XC";
        }
        return "";
    }
    public String getOString(int one) {
        switch (one) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
        }
        return "";
    }
    public String intToRoman(int num) {
        StringBuilder strBuilder = new StringBuilder();

        if (num >= 1000) {
            int thousand = num / 1000;
            num = num % 1000;
            int hundred = num / 100;
            num = num % 100;
            int ten = num / 10;
            int one = num % 10;
            strBuilder.append(getTString(thousand)).append(getHString(hundred)).append(getTenString(ten)).append(getOString(one));
        } else if (num >= 100) {
            int hundred = num / 100;
            num = num % 100;
            int ten = num / 10;
            int one = num % 10;
            strBuilder.append(getHString(hundred)).append(getTenString(ten)).append(getOString(one));
        } else if (num >= 10) {
            int ten = num / 10;
            int one = num % 10;
            strBuilder.append(getTenString(ten)).append(getOString(one));
        }else {
            strBuilder.append(getOString(num));
        }

        return strBuilder.toString();
    }*/
    
    //逐个减掉对应的数
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while(num > values[i]) {
                num -= values[i];
                str.append(strs[i]);
            }
        }
        return str.toString();
    }
}
