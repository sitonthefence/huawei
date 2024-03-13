package LC;

import java.util.Stack;

public class LC20有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('){
                stack.push('(');
            }else if(c=='['){
                stack.push('[');
            }else if (c=='{'){
                stack.push('{');
            }else if(c==')'){
                if(stack.size()>0&&stack.peek()=='('){
                    stack.pop();
                }else {
                    stack.push(')');
                }

            }else if(c==']'){
                if(stack.size()>0&&stack.peek()=='['){
                    stack.pop();
                }else {
                    stack.push(']');
                }

            }else if(c=='}'){
                if(stack.size()>0&&stack.peek()=='{'){
                    stack.pop();
                }else {
                    stack.push('}');
                }

            }
        }
        if (stack.size()==0) return true;
        return false;


    }
}
