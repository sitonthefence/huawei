package huawei100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(in.nextInt());
            }
            Collections.sort(list);
            int N=in.nextInt();
            int sum =0;
            for (int i = 0; i <N ; i++) {
                sum=sum+list.get(i);
            }
            for (int i =list.size()-N; i<list.size(); i++) {
                sum=sum+list.get(i);
            }
            System.out.println(sum);





        }


    }


}
