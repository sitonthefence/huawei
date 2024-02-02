package huaweiC200;

import java.util.*;

public class HW23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < split.length; i++) {
                queue.offer(Integer.valueOf(split[i]));
            }
            int[] employee=new int[Integer.valueOf(in.nextLine())];
            int time=0;
            while (!queue.isEmpty()){
              //  Arrays.sort(employee);
                for (int i = 0; i < employee.length; i++) {
                    if(employee[i]==0&&!queue.isEmpty()){
                        employee[i]=queue.poll();
                        employee[i]--;
                    }else if(employee[i]>0){
                        employee[i]--;
                    }
                }

                time++;
            }
            int max=0;
            for (int i = 0; i < employee.length; i++) {
                time+=Math.max(max,employee[i]);
            }
            System.out.println(time);
        }
    }
}
