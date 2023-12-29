package huaweiAB100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < split.length-1; i++) {
                for (int j = i+1; j < split.length; j++) {
                    min=Math.min(min,Math.abs(Integer.valueOf(split[i])+Integer.valueOf(split[j])));
                }
            }
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < split.length; i++) {
                if(map.containsKey(min-Integer.valueOf(split[i]))){

                    System.out.print(min-Integer.valueOf(split[i])+" "+Integer.valueOf(split[i])+" ");
                }
                else {
                    map.put(Integer.valueOf(split[i]),i);
                }
            }
            System.out.println(min);


        }

    }




}
