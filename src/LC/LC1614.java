package LC;

import java.util.ArrayDeque;

public class LC1614 {
    public static void main(String[] args) {



    }
    public static int maxDepth(String s) {
        ArrayDeque<Character> deque=new ArrayDeque<>();
        int max=0;
        int i=0;
        while (i<s.length()){
            char c=s.charAt(i);
            if(c=='('){
                deque.addLast('(');
                max=Math.max(max,deque.size());
            }
            if(c==')'){
                deque.pollLast();
            }
            i++;
        }
        return max;



    }
}
