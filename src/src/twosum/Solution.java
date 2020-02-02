package twosum;
import java.math.BigInteger;
import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

public class Solution{
    public static void main(String[] args){
        TwoSum sum = new TwoSum();
        int[] nums = {4,8,3,6};
        int target = 11;
        System.out.println(Arrays.toString(sum.twoSum(nums, target)));
        BigInteger a = new BigInteger("10000000000000000000000000000000000000000000");
        BigInteger b = a.add(BigInteger.valueOf(0));
        System.out.println(b.byteValue());
    }
}