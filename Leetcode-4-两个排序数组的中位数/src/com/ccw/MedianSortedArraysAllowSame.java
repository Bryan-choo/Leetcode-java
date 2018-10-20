package com.ccw;

/**
 * @Auther: ccw
 * @Date: 2018/7/14 14:34
 * @Description:
 */
public class MedianSortedArraysAllowSame {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int p = 0;
        int i = 0;
        int j = 0;
        while (i<m && j<n) {
            if (nums1[i] <= nums2[j]) {
                result[p++] = nums1[i++];
            } else {
                result[p++] = nums2[j++];
            }
        }
        while (i < m) {
            result[p++] = nums1[i++];
        }
        while (j < n) {
            result[p++] = nums2[j++];
        }

//        for(int t:result)
//            System.out.print(t+" ");
//        System.out.println();
        int mid = result.length/2;
        if(result.length%2 == 0) {
            return (result[mid-1]+result[mid])/2.0;
        } else {
            return result[mid];
        }

    }

    public static void main(String[] args) {

        double result = MedianSortedArraysAllowSame.findMedianSortedArrays(new int[] {1,1}, new int[] {1,2});
        System.out.println(result);
    }

}
