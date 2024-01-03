package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length=in.nextInt();
            PriorityQueue<Integer> queue=new PriorityQueue<>();
            List<Integer>[]  arr=new List[100005];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=new ArrayList<>();
            }
            int total=0;
            for (int i = 0; i < length; i++) {
                arr[in.nextInt()].add(in.nextInt());
            }
            for (int i = 1; i < arr.length; i++) {
                while (!queue.isEmpty()&&queue.peek()<i){
                    queue.poll();
                }
                for (int j = 0; j < arr[i].size(); j++) {
                    queue.add(arr[i].get(j));
                }
                if (!queue.isEmpty()){
                    queue.poll();
                    total++;
                }
            }
            System.out.println(total);
        }
    }

}
