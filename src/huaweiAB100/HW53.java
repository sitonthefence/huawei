package huaweiAB100;

import java.util.*;

public class HW53 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int target = in.nextInt();
            LinkedList<Integer> deque=new LinkedList<>();
            for (int i = 1; i <=100; i++) {
                deque.offerLast(i);
            }
            int num=1;
            while (deque.size()>=target){
                if(num==target){
                    deque.pollFirst();
                    num=1;
                }else {
                    deque.offerLast(deque.pollFirst());
                    num++;
                }
            }
            StringBuilder stringBuilder=new StringBuilder();
           Collections.sort(deque);
         while (!deque.isEmpty()){
           stringBuilder.append(deque.pollFirst()).append(",");
         }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }
    }

}
