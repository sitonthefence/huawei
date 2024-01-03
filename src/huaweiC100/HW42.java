package huaweiC100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HW42 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            Integer[] arr=new Integer[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            Arrays.sort(arr, Comparator.reverseOrder());
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            for (int i = 0; i < length; i++) {
                deque.add(arr[i]);
            }
            int count=0;
            int target = in.nextInt();

               while (!deque.isEmpty()&&deque.peekFirst()>=target){
                   deque.pollFirst();
                   count++;
               }
               while (deque.size()>=2){
                if(deque.peekFirst()+ deque.peekLast()>=target){
                    deque.pollFirst();
                    deque.pollLast();
                    count++;
                }else {
                    deque.pollLast();
                }

               }
            System.out.println(count);
        }


    }
}
