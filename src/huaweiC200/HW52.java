package huaweiC200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] score=new int[length];
            for (int i = 0; i < score.length; i++) {
                score[i]=in.nextInt();
            }
             int k=in.nextInt();
            //小心
              k++;
            int[] dp=new int[length];
            dp[0]=score[0];
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            deque.add(dp[0]);
            //小心
            for (int i = 1; i < Math.min(k,length); i++) {
                 dp[i]=score[i]+deque.peekFirst();
                while (!deque.isEmpty()&&dp[i]>deque.peekLast()){
                    deque.pollLast();
                }
                deque.offerLast(dp[i]);
            }
            for (int i = k; i <length ; i++) {

                if(deque.peekFirst()==dp[i-k]){
                    deque.pollFirst();
                }
                dp[i]=score[i]+deque.peekFirst();
                while (!deque.isEmpty()&&dp[i]>deque.peekLast()){
                    deque.pollLast();
                }
                deque.offerLast(dp[i]);
            }
            System.out.println(dp[length-1]);

            }
        }




}
