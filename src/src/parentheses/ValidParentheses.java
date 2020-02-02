package parentheses;

import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String x){
        char[] parentheses = x.toCharArray();
        List<Character> stack = new LinkedList<>();
        for (char par: parentheses){
            int pop = stack.size()-1;
            if (stack.isEmpty() || par=='[' || par == '(' || par == '{'){
                stack.add(par);
                continue;
            }
            if (stack.get(stack.size()-1)=='('){
                if (par==')'){
                    stack.remove(stack.size()-1);
                    continue;
                }
                else {return false;}
            }
            if (stack.get(stack.size() - 1) == '['){
                if (par==']'){
                    stack.remove(stack.size()-1);
                    continue;
                }
                else {return false;}
            }
            if (stack.get(stack.size() - 1) == '{'){
                if (par=='}'){
                    stack.remove(stack.size()-1);
                }
                else {return false;}
            }
        }
        if (stack.size()!=0){return false;}
        return true;
    }
    public static void main(String[] args){
        System.out.println(ValidParentheses.isValid("{([)}[]]()"));
    }
}
