package LC;

import java.util.ArrayDeque;
import java.util.Stack;

public class LC735 {
    public static void main(String[] args) {
        asteroidCollision(new int[]{-2,-2,1,-2});
    }
    public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean alive=true;
            while (alive&&asteroids[i]<0&&!deque.isEmpty()&&deque.peekLast()>0){
                alive=(-asteroids[i]>deque.peekLast());
                if(-asteroids[i]>=deque.peekLast()){
                    deque.pollLast();
                }
            }
            if(alive){
                deque.offerLast(asteroids[i]);
            }


        }
        int[] ans=new int[deque.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=deque.pollFirst();
        }
        return ans;



    }
}
