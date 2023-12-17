package NK;

import java.util.Scanner;

public class HJ105 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count1=0;
        int count2=0;
        double sum=0.0;
        double average=0.0;
        while (in.hasNextInt()){
            int source = in.nextInt();
            if(source<0){
                count1++;
            }else {
                sum=sum+source;
                count2++;

            }
        }
        if (count2==0){
            average=0.0;
        }else {
            average=sum/ count2;
        }

        System.out.println(count1);
        System.out.println(String.format("%.1f",average));





    }




}
