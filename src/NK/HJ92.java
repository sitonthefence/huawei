package NK;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class HJ92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split("[^0-9]");
            LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
            for (int i = 0; i < split.length; i++) {
                map.put(split[i],split[i].length());
            }
            int max=Integer.MIN_VALUE;
            for (Integer value : map.values()) {
                max=Math.max(max,value);
            }
            for (String s : map.keySet()) {
                if(map.get(s)==max){

                    System.out.print(s);
                }

            }
            System.out.println(","+max);


        }


    }



}
