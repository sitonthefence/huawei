package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int lengthA = in.nextInt();
            int lengthB = in.nextInt();
            int sumA=0;
            int sumB=0;
            int[] arrA=new int[lengthA];
            int[] arrB=new int[lengthB];
            for (int i = 0; i < lengthA; i++) {
                arrA[i]=in.nextInt();
                sumA=arrA[i]+sumA;
            }
            Arrays.sort(arrA);
            for (int i = 0; i < lengthB; i++) {
                arrB[i]=in.nextInt();
                sumB=arrB[i]+sumB;
            }
            Arrays.sort(arrB);
            int avg=(sumA+sumB)/2;
            if(sumA-avg<0){
                tag:
                for (int i = 0; i <lengthA ; i++) {
                    for (int j = 0; j < lengthB; j++) {
                        if(arrB[j]-arrA[i]==avg-sumA){
                            System.out.println(arrA[i]+" "+arrB[j]);
                            break tag;
                        }
                    }
                }
            }else {
                tag:
                for (int i = 0; i <lengthA ; i++) {
                    for (int j = 0; j < lengthB; j++) {
                        if(arrA[i]-arrB[j]==sumA-avg){
                            System.out.println(arrA[i]+" "+arrB[j]);
                            break tag;
                        }
                    }
                }


            }



        }


    }
}
