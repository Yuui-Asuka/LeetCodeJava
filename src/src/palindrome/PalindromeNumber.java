package palindrome;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public static boolean isPalindrome(int x){
        List<Character> number = new ArrayList<>();
        if (x <= 0){
            return false;
        }
        while (x > 0){
            int curr = x % 10;
            number.add((char)curr);
            x /= 10;
        }

        for (int i = 0, j = number.size()-1; i<number.size()/2&&j>=number.size()/2; i++,j--){
            if (number.get(i) != number.get(j)){return false;}
        }
        return true;

    }
    public static void main(String[] args){
        System.out.println(isPalindrome(15351));
    }

}


