package huaweiC200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            int[] arr=new int[source.length()];
            for (int i = 0; i <arr.length ; i++) {
                arr[i]=source.charAt(i)-'0';
            }
            int k = in.nextInt();
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            deque.offerLast(arr[0]);
            for (int i = 1; i <arr.length ; i++) {
                while (!deque.isEmpty()&&k>0&&deque.peekLast()>arr[i]){
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(arr[i]);
            }
        while (k>0){
           deque.pollLast();
           k--;
       }
        while (!deque.isEmpty()&&deque.peekFirst()==0){

           deque.pollFirst();
       }
        if(deque.size()==0){
            System.out.println(0);
            continue;
        }
        StringBuilder stringBuilder=new StringBuilder();
          while (!deque.isEmpty())
             stringBuilder.append(deque.pollFirst());

            System.out.println(stringBuilder);

        }

    }
}
