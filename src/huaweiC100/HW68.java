package huaweiC100;

import java.util.Scanner;

public class HW68 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()){
                int length = in.nextInt();
                int luckyNumber = in.nextInt();
                int[] arr=new int[length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i]=in.nextInt();
                }


                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]<0&&arr[i]==luckyNumber){
                        arr[i]=arr[i]-1;
                    }
                    if(arr[i]>0&&arr[i]==luckyNumber){
                        arr[i]=arr[i]+1;
                    }
                }
                int[] result=new int[length];
                result[0]=arr[0];
                for (int i = 1; i < result.length; i++) {
                    result[i]=arr[i]+result[i-1];
                }
                int max=0;
                for (int i = 0; i <result.length ; i++) {
                    max=Math.max(max,result[i]);

                }
                System.out.println(max);
            }
        } catch (Exception e) {
            System.out.println(12345);
        }


    }
}
