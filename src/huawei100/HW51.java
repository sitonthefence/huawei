package huawei100;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] nums=new int[length];
            for (int i = 0; i < length; i++) {
                nums[i]=in.nextInt();
            }
            int[] result=new int[length];
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                      result[deque.pollLast()]= i;
                }
                deque.offer(i);
            }
            for (int i = 0; i <result.length ; i++) {
                System.out.print(result[i]+" ");
            }
        }
    }
}
