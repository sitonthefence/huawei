package huaweiAB100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       while (in.hasNextInt()){
           int length = in.nextInt();
           List<String> list=new ArrayList<>();
           for (int i = 0; i < length; i++) {
               list.add(in.next());
           }
           list.sort(((o1, o2) ->getTime(o1)-getTime(o2) ));
           for (int i = 0; i < length; i++) {
               System.out.println(list.get(i));
           }




       }



    }
    public static int getTime(String time){
        String[] split = time.split(":|\\.");
        int h=Integer.valueOf(split[0]);
        int m=Integer.valueOf(split[1]);
        int s=Integer.valueOf(split[2]);
        int n=Integer.valueOf(split[3]);
        return n+s*1000+m*60*1000+h*60*60*1000;

    }














}
