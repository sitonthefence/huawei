package huaweiC200;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HW23TWO {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        PriorityQueue<Integer> deque=new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i <split.length ; i++) {
            deque.add(Integer.parseInt(split[i]));
        }
        int personNum = in.nextInt();
        int[] person=new int[personNum];
        int time=0;
        while (!deque.isEmpty()){
            for (int i = 0; i < person.length; i++) {
               if(!deque.isEmpty()&&person[i]==0){
                  person[i] = deque.poll();
                  person[i]--;
               }else if(person[i]>0){
               person[i]--;
               }
            }
            time++;
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <person.length ; i++) {
            max=Math.max(max,person[i]);
        }
        System.out.println(time+max);
    }

}
