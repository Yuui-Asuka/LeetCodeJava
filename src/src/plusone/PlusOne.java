package plusone;

import java.math.BigInteger;
import java.util.*;

public class PlusOne {
    public static int[] plusOne(int[] x){
        int[] a = {0};
        BigInteger multi = BigInteger.valueOf(1);
        BigInteger res = BigInteger.valueOf(0);
        BigInteger ten = BigInteger.valueOf(10);
        int[] res2 = new int[x.length];
        Set <Integer> set = new HashSet<>();
        for (int i = 0; i < x.length-1; i++)
        {multi = multi.multiply(ten);}
        BigInteger multi2 = multi.add(BigInteger.valueOf(0));
        for(int i: x){
            res = res.add(multi.multiply(BigInteger.valueOf(i)));
            multi = multi.divide(ten);
            set.add(i);
        }
        if (set.size()==1 && set.contains(9)){
            multi2 = multi2.multiply(ten);
            res2 = new int[x.length+1];
        }
        res = res.add(BigInteger.valueOf(1));
        for (int i=0; i<res2.length; i++){
            int curr = res.divide(multi2).intValue();
            res = res.subtract(multi2.multiply(BigInteger.valueOf(curr)));
            res2[i] = curr;
            multi2 = multi2.divide(ten);
        }
        return res2;
    }
    public static void main(String[] args){
        int[] arr = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
