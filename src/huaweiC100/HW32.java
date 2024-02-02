package huaweiC100;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW32 {
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
            Arrays.sort(works,(o1,o2)->o1[0]-o2[0]);
            PriorityQueue<Integer> deque=new PriorityQueue<>();
            int ans=0;
            int startTime=0;
            for (int[] work : works) {
                int endTime=work[0];
                int goal=work[1];
                if(startTime<endTime){
                   ans+=goal;
                   startTime++;
                    deque.add(goal);
                }else if(!deque.isEmpty()&&deque.peek()<goal){
                    ans-=deque.poll();
                    ans+=goal;
                    deque.add(goal);
                }
            }
            while (deque.size()>totalTime){
                ans-=deque.poll();
            }
            System.out.println(ans);
        }
    }
}
