package huaweiC200;

import java.util.*;

public class HW51TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
         List<Integer>[] arr=new List[100005];
        for (int i = 0; i < arr.length; i++) {
             arr[i]=new ArrayList<>();
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            arr[in.nextInt()].add(in.nextInt());
        }

        PriorityQueue<Integer> deque=new PriorityQueue<>();

        for (int i = 1; i < arr.length ; i++) {
            while (!deque.isEmpty()&&i>deque.peek()){
                deque.poll();
            }
            for (int j = 0; j < arr[i].size(); j++) {
                deque.add(arr[i].get(j));

            }

            if(!deque.isEmpty()){
                deque.poll();
                count++;
            }

        }
        System.out.println(count);



    }
}
