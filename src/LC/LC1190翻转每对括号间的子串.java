package LC;

import java.util.Stack;

public class LC1190翻转每对括号间的子串 {
    public static void main(String[] args) {

    }

    public static String reverseParentheses(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i)=='('){
                 stack.push(stringBuilder.toString());
                stringBuilder.setLength(0);
             }else if(s.charAt(i)==')'){
                 stringBuilder.reverse();
                 stringBuilder.insert(0,stack.pop());
             }else {
                 stringBuilder.append(s.charAt(i));
             }


        }
        return stringBuilder.toString();

    }
}
