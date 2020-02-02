package median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Median {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<>();
        for (int i: nums1){list.add(i);}
        for (int i: nums2){list.add(i);}
        Collections.sort(list);
        if (list.size()%2 == 0){
            int s1 = list.get(list.size()/2);
            int s2 = list.get(list.size()/2-1);
            return ((double) s1+s2)/2;
        }
        else {return list.get(list.size()/2);}
    }
}


public class Solution{
    public static void main(String[] args){
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double res = Median.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}