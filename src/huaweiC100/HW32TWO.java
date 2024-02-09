package huaweiC100;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW32TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int totalTime=in.nextInt();
           int[][] works=new int[length][2];
            for (int i = 0; i < length; i++) {
                works[i][0]=in.nextInt();
                works[i][1]=in.nextInt();
            }
            Arrays.sort(works,(a,b)->a[0]-b[0]);
             PriorityQueue<Integer> deque=new PriorityQueue<>();
            int startTime=0;
            for (int[] work : works) {
                int endTime=work[0];
                int goal=work[1];
                if(startTime<endTime){
                    deque.add(goal);
                    startTime++;
                }else if(!deque.isEmpty()&&goal>deque.peek()){
                    deque.poll();
                    deque.add(goal);
                }
            }
            while (deque.size()>totalTime){
                deque.poll();
            }
            int ans=0;
            while (!deque.isEmpty()){
                ans+=deque.poll();
            }
            System.out.println(ans);



        }
    }
}
