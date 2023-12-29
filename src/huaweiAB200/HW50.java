package huaweiAB200;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            Integer[] arr=new Integer[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            Arrays.sort(arr,(o1,o2)->o2.intValue()-o1.intValue());
            System.out.println();
            PriorityQueue<Integer> queue=new PriorityQueue<>();

            for (int i = 0; i < arr.length; i++) {
           if(queue.isEmpty()|| queue.peek()+arr[i]>500){
               queue.offer(arr[i]);
           }else {
               queue.offer(queue.poll()+arr[i]);

           }
            }
            System.out.println(queue.size());

        }


    }



}
