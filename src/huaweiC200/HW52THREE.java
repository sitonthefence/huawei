package huaweiC200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW52THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] score=new int[length];
        for (int i = 0; i < length; i++) {
            score[i]=in.nextInt();
        }
        int k = in.nextInt();
        k++;
        int[] dp=new int[length];
        dp[0]=score[0];
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        deque.offerLast(dp[0]);
        for (int i = 1; i <Math.min(k,length) ; i++) {
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
