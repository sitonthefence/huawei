package huaweiC100;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW9TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] arr=new int[length];
            int[] result=new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            for (int i = 0; i <arr.length ; i++) {
                while (!deque.isEmpty()&&arr[i]>arr[deque.peekLast()]){
                     result[deque.pollLast()]=i;
                }
                deque.add(i);
            }

            for (int i : result) {
                System.out.print(i+" ");
            }
        }
    }
}
