package NC37;

import java.util.ArrayDeque;

public class NC52 {


    public class Solution {


        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean isValid (String s) {
            ArrayDeque<Character> deque=new ArrayDeque<>();
            int i=0;
            while (i<s.length()){
                char c=s.charAt(i);
                  if(c==')'&&!deque.isEmpty()&&deque.peekLast()=='(')
                {
                    deque.pollLast();
                }else if (c==']'&&!deque.isEmpty()&&deque.peekLast()=='[')
                {
                    deque.pollLast();
                }else if(c=='}'&&!deque.isEmpty()&&deque.peekLast()=='{'){
                    deque.pollLast();
                }else {
                    deque.offerLast(c);
                }
                i++;
            }
            if(deque.isEmpty()) return true;
            return false;




        }
    }
}
