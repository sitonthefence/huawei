package NK;

import java.util.Scanner;

public class H97 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arr=new int[length];
        for (int i = 0; i < length; i++) {
           arr[i]=in.nextInt();
        }
        int count1=0;
        double sum=0.0;
        int count2=0;
        for (int i = 0; i < length; i++) {
            if (arr[i]<0){
                count1++;
            }
            if (arr[i]>0) {
                count2++;
                sum=arr[i]+sum;
            }
        }
        System.out.print(count1+" ");
        if (count2 == 0) {
            System.out.println("0.0");

        }else {
            System.out.println(String.format("%.1f",sum/count2));

        }







    }




}
