package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW68 {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()){
                int length = in.nextInt();
                if(length<1||length>100){
                    System.out.println("12345");
                    return;
                }

                int luckyNumber = in.nextInt();
                if(luckyNumber<-100||luckyNumber>100){
                    System.out.println("12345");
                    return;
                }
                int[] arr=new int[length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i]=in.nextInt();
                    if(arr[i]<-100||arr[i]>100){
                        System.out.println("12345");
                        return;
                    }
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
                System.out.println(Arrays.stream(result).max().orElse(0));
            }
        }


    }

