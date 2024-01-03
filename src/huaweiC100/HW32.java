package huaweiC100;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HW32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int totalTime=in.nextInt();
            PriorityQueue<int[]> queue=new PriorityQueue<>((o1, o2) ->
            {
                if(o1[0]==o2[0]){
                   return o2[1]-o1[1];
                }else {
                   return o1[0]-o2[0];
                }
            });
            for (int i = 0; i < length; i++) {
                queue.add(new int[]{in.nextInt(),in.nextInt()});
            }
            int total=0;
            for (int i = 1; i <=totalTime; i++) {
                while (!queue.isEmpty()&&queue.peek()[0]<i){
                    queue.poll();
                }
                if(!queue.isEmpty()){
                    total+=queue.poll()[1];
                }
            }
            System.out.println(total);
        }
    }
}
