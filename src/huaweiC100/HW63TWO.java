package huaweiC100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class HW63TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int lengthA = in.nextInt();
            int lengthB = in.nextInt();
            int sumA=0;
            int sumB=0;
            int[] arrA=new int[lengthA];
            int[] arrB=new int[lengthB];
            HashSet<Integer> setB=new HashSet<>();
            for (int i = 0; i < lengthA; i++) {
                arrA[i]=in.nextInt();
                sumA=arrA[i]+sumA;
            }
            Arrays.sort(arrA);
            for (int i = 0; i < lengthB; i++) {
                arrB[i]=in.nextInt();
                setB.add(arrB[i]);
                sumB=arrB[i]+sumB;

            }

            Arrays.sort(arrB);
            int avg=(sumA+sumB)/2;

            for (int i = 0; i < arrA.length; i++) {
                  if(setB.contains(avg-sumA+arrA[i])){
                      System.out.print(arrA[i]+" ");
                      System.out.println(avg-sumA+arrA[i]);
                      break;
                }


            }
        }


    }
}
