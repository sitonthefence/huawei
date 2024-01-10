package huaweiC100;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            int[] arr=new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            int[] result=new int[split.length];
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            for (int i = 0; i < 2*arr.length-1; i++) {
                while (!deque.isEmpty()&&arr[deque.peekLast()]>arr[i%arr.length]){
                  result[deque.pollLast()]=arr[i%arr.length];
                }
                deque.add(i%arr.length);

            }
            int [] target=new int[split.length];
            for (int i = 0; i < target.length; i++) {
                target[i]=arr[i]+result[i];
            }
            for (int i : target) {
                System.out.print(i+" ");
            }



        }
    }
}
