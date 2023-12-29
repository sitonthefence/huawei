package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW80 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i <split.length ; i++) {
                list.add(Integer.valueOf(split[i]));

            }
            int jump = in.nextInt();
            int surviveLeft = in.nextInt();
             int index=0;
            index=(index+jump+1)%list.size();
            while (list.size()>surviveLeft){
                list.remove(index);
                index=(index+jump)%list.size();
            }
            int sum=0;
            for (int i = 0; i < list.size(); i++) {
                sum=sum+list.get(i);
            }
            System.out.println(sum);



        }

    }
}
