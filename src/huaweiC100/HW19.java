package huaweiC100;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW19 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < length; i++) {
                queue.offer(in.nextInt());
            }
            while (queue.size()>=3){
                int z=queue.poll();
                int y=queue.poll();
                int x= queue.poll();
                if(x==y&&y!=z){
                queue.offer(z-y);
                }else if(x!=y&&y==z){
                    queue.offer(y-z);
                }else if(x!=y&&y!=z){
                    queue.offer(Math.abs((z-y)-(y-x)));
                }
            }
            if(queue.size()==0){
                System.out.println(0);
            }else{
                System.out.println(queue.peek());
            }


        }


    }



}
