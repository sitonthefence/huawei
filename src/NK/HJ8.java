package NK;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class HJ8 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        Map<Integer,Integer>map=new TreeMap<>();



        for(int i=0;i<total;i++){

            int a=in.nextInt();
            int b=in.nextInt();
            map.put(a,map.getOrDefault(a,0)+b);

        }
        for (Map.Entry<Integer, Integer> set:
        map.entrySet()) {
            System.out.println(set.getKey()+" "+ set.getValue());


        }




    }





}
