package huaweiAB100;

import java.util.Scanner;

public class HW46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");

             int min=Integer.MAX_VALUE;
            for (int i = 1; i < split.length/2; i++) {
                int count=1;
                int    index=i;
                while (index<split.length){
                    index=Integer.valueOf(split[index])+index;
                    count++;
                    if(index==split.length-1){

                        min=Math.min(count,min);
                    }
                }
            }
                if(min==Integer.MAX_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(min);

            }


        }


    }
}
