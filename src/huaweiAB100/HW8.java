package huaweiAB100;

import java.util.Scanner;

public class HW8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int length=Integer.valueOf(in.nextLine());
            int sum=0;
            for (int i = 0; i < length; i++) {
                sum=sum+getRowSum(in.nextLine());
            }
            System.out.println(sum);
        }
    }
     public static int getRowSum (String source){
         String[] split = source.split(",");
         int max=Integer.MIN_VALUE;
         for (int i = 0; i <split.length; i++) {
             StringBuilder stringBuilder=new StringBuilder();
             for (int j =0; j< split.length; j++) {
                 stringBuilder.append(Integer.valueOf(split[(i+j)%split.length]));
             }
             Integer integer = Integer.valueOf(stringBuilder.toString(), 2);
             max=Math.max(integer,max);
         }
         return max;
     }

}

