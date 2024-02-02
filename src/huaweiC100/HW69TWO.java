package huaweiC100;

import java.util.Scanner;

public class HW69TWO {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        if(length<3){
            System.out.println(0);
            return;
        }
        int[] arr=new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]= in.nextInt();
        }
        long result=0;
        for (int i =1 ; i <length-1 ; i++) {
            int a=0;
            int b=0;
            int c=0;
            int d=0;
            for (int j = 0; j <i ; j++) {
                if(arr[j]<arr[i]){
                    a++;
                }else if(arr[j]>arr[i]){
                    c++;
                }
            }
            for (int j = i+1; j<length  ; j++) {
                if(arr[j]>arr[i]){
                    b++;
                }else if(arr[j]<arr[i]){
                    d++;
                }

            }
            result+=a*b+c*d;
        }
        System.out.println(result);


    }



}
