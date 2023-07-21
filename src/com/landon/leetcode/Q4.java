package com.landon.leetcode;

public class Q4 {
    //方法一：合并为一个数组
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double r;
        int i = 0, j = 0, k = 0;
        int[] temp = new int[nums1.length+ nums2.length];
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length || j == nums2.length) {
                break;
            }
            if (nums1[i]<=nums2[j]) {
                temp[k++] = nums1[i++];
            }else {
                temp[k++] = nums2[j++];
            }
        }
        while(i < nums1.length) {
            temp[k++] = nums1[i++];
        }
        while(j < nums2.length) {
            temp[k++] = nums2[j++];
        }
        if (k % 2 == 1) {
            r = temp[k/2];
        }else {
            r = ((double) temp[k/2-1] + (double)temp[k/2])/2;
        }
        return  r;
    }*/

    //方法二：逐个淘汰
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int length = m + n;
        //游标
        int cur1 = 0, cur2 = 0;
        //a记录位置上的值，b记录a前一次的位置上的值
        int a = 0, b = 0;
        for (int i = 0; i <= length / 2; i++) {
            b = a;
            //nums1中元素全部淘汰，nums2数组游标右移
            if (cur1 >= m) {
                a = nums2[cur2++];
                continue;
            }
            //nums2中元素全部淘汰
            if (cur2 >= n) {
                a = nums1[cur1++];
                continue;
            }
            if (nums1[cur1] <= nums2[cur2]) {
                a = nums1[cur1++];
            }else {
                a= nums2[cur2++];
            }
        }
        if (length % 2 == 1) {
            return a;
        }else {
            return (a + b) / 2.0;
        }
    }*/
    //二分法，理解成找第K小的数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int length = m + n;
        int mid1 = (m + n + 1) / 2;
        int mid2 = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, mid1) + getKth(nums1, 0, nums2, 0, mid2)) / 2.0;
    }
    public int getKth (int[] nums1, int i, int[] nums2, int j, int k) { //i:nums1的起始位置；j:nums2的起始位置
        if (i >= nums1.length) {return nums2[j + k - 1];} //num1为空，nums2中找第k小
        if (j >= nums2.length) {return nums1[i + k - 1];} //num2为空，nums1中找第k小
        if (k == 1) {return Math.min(nums1[i], nums2[j]);}
        int midVal1 = (i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE);
        int midVal2 = (j + k / 2 - 1 < nums2.length ? nums2[j + k / 2 + 1] : Integer.MAX_VALUE);
        if (midVal1 <= midVal2) {
            return getKth(nums1, i + k / 2, nums2, j, k - k / 2);
        }else {
            return getKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
