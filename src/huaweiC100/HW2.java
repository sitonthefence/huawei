package huaweiC100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int lengthA = in.nextInt();
            int[] arrA=new int[lengthA];
            for (int i = 0; i < lengthA; i++) {
                arrA[i]=in.nextInt();
            }
            int lengthB = in.nextInt();
            int[] arrB=new int[lengthB];
            for (int i = 0; i < lengthB; i++) {
                arrB[i]=in.nextInt();
            }
            List<Integer> result=new ArrayList<>();
            for (int i = 0; i < arrA.length; i++) {
                for (int j = 0; j < arrB.length; j++) {
                    result.add(arrA[i]+arrB[j]);

                }
            }
            Collections.sort(result);
            int k = in.nextInt();
            int sum=0;
            for (int i = 0; i < k; i++) {
                sum+=result.get(i);
            }
            System.out.println(sum);
        }
    }
}
