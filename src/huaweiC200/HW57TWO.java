package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW57TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int totalDay = in.nextInt();
            int crossCity = in.nextInt();
            int spendDay=0;
            for (int i = 0; i < crossCity+1; i++) {
                spendDay+=in.nextInt();
            }
            int remainDay=totalDay-spendDay;
            List<int[]> list=new ArrayList<>();
            for (int i = 0; i < crossCity; i++) {
                list.add(new int[]{in.nextInt(),in.nextInt()});
            }
            PriorityQueue<Integer> queue=new PriorityQueue<>();
            if(remainDay<=0){
                System.out.println(0);
                continue;
            }
            for (int[] ints : list) {
                int m = ints[0];
                int d = ints[1];
                while (m>0){
                    if(queue.size()<remainDay){
                        queue.add(m);
                    }else {
                    if(m> queue.peek()){
                        queue.poll();
                        queue.add(m);
                    }else {
                        break;
                    }
                    }
                    m=m-d;
                }

            }
            int sum=0;
            while (!queue.isEmpty()){
                sum+=queue.poll();
            }
            System.out.println(sum);





        }
    }
}
