package huaweiAB100;

import java.util.Scanner;

public class HW54 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){

            String source = in.nextLine();
            String[] split = source.split(",");
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < split.length-1; i++) {
                for (int j = i+1; j <split.length ; j++) {
                    int result = (j-i)
                            * Math.min(Integer.valueOf(split[i]), Integer.valueOf(split[j]));
                   max=Math.max(max,result);
                }
            }
            System.out.println(max);





        }





    }
}
