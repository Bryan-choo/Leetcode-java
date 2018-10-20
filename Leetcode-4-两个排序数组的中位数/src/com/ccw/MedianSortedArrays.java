package com.ccw;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ccw
 * @Date: 2018/7/14 13:12
 * @Description:
 */
public class MedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2. length;
//        int [] result = new int[m+n];
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<m && j<n) {
            if(nums1[i]<=nums2[j]) {
                result.add(nums1[i++]);
            } else {
                if(result.contains(nums2[j])) {
                    j++;
                    continue;
                }
                result.add(nums2[j++]);
            }
        }
        if(i < m) {
            while(i<m) {
                if(!result.contains(nums1[i]))
                    result.add(nums1[i++]);
                else
                    i++;
            }
        }
        if(j < n) {
            while(j<n) {
                if(!result.contains(nums2[j]))
                    result.add(nums2[j++]);
                else
                    j++;
            }
        }

        Integer[] res = new Integer[result.size()];
        res = result.toArray(res);

//        for(Integer t : res)
//            System.out.print(t+" ");
//        System.out.println();
        if(res.length%2 == 0) {
            int mid = res.length/2;
            return (res[mid-1]+res[mid])/2.0;
        } else {
            int mid = res.length/2;
            return res[mid];
        }
    }

    public static void main(String []args) {

        double result = MedianSortedArrays.findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[] {3,4});
        System.out.println(result);
    }
}
