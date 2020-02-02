package reverseint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Reverse {
    public static int reverse(int x) {
        long devide = 1;
        long result = 0;
        List<Integer> nums = new ArrayList<>();
        List<Long> devides = new ArrayList<>();
        while (Math.abs(x / devide) >= 1) {
            devides.add(devide);
            devide *= 10;
        }
        //Collections.reverse(devides);
        for (int i = devides.size()-1; i>=0 ; i--) {
            int num = (int) (x / devides.get(i));
            x -= num * devides.get(i);
            nums.add(num);
        }
        //Collections.reverse(devides);
        for (int i = 0; i < nums.size(); i++) {
            result += nums.get(i) * devides.get(i);
        }
        if (result > (Math.pow(2, 31) - 1) || result < (-Math.pow(2, 31))) {
            return 0;
        }
        else {return (int) result;}
    }
}


public class Solution{
    public static void main(String[] args){
        int res = Reverse.reverse(36469);
//        int result = 0;
//        for (int i = 0; i < res.size(); i++){
//            result += Math.pow(2, i) * res.get(i);
//        }
        System.out.println(res);
    }
}