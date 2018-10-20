package com.ccw;

import java.util.LinkedList;
import java.util.Random;

/**
 * @Auther: ccw
 * @Date: 2018/7/15 08:56
 * @Description:
 */

public class SortedPlate {

    public static Integer[] findSortedPlate(int n) {
        if(n<=0)
            return null;
        LinkedList<Integer> list = new LinkedList<>();
        list.offerLast(n--);
        while(n!=0) {
            Integer e = list.pollLast();
            list.offerFirst(e);
            list.offerFirst(n--);
        }
        Integer[] result = new Integer[n];
        result = list.toArray(result);
//        for(Integer i:result)
//            System.out.print(i+" ");
//        System.out.println();
        return result;
    }

    public static boolean check(Integer[] array) {
        if(null == array) {
            System.out.print("array is null");
            return false;
        }
        if(array.length <= 1)
            return true;
        Integer[] result = new Integer[array.length];
//        System.out.println("length: "+array.length);
        LinkedList<Integer> list = new LinkedList<>();
        for(Integer i:array)
            list.offerLast(i);
        int p = 0;
        while(list.size() !=  0) {
            Integer tm = list.pollFirst();
            result[p++] = tm;
            Integer t = list.pollFirst();
            if(null == t)
                continue;
            else
                list.offerLast(t);
        }
        return checkIncreament(result);
    }

    public static boolean checkIncreament(Integer[] array) {
        if(array.length<=1)
            return true;
//        System.out.print("check: ");
//        for(Integer i:array)
//            System.out.print(i+" ");
//        System.out.println();
        for(int i = 0; i<array.length-1; i++) {
            int j = i+1;
            if(array[i]>array[j])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Random random = new Random();
        for(int i = 0; i<1000; i++) {
            System.out.println(SortedPlate.check(SortedPlate.findSortedPlate(random.nextInt(100))));
        }
    }
}
