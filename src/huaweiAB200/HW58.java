package huaweiAB200;

import java.util.Arrays;
import java.util.Scanner;

public class HW58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] numA=new int[length];
            int[] numB=new int[length];
            for (int i = 0; i <numA.length ; i++) {
                numA[i]=in.nextInt();
            }
            Arrays.sort(numA);
            for (int i = 0; i < numB.length; i++) {
                numB[i]=in.nextInt();
            }
            Arrays.sort(numB);
            int numALeft=0;
            int numBLeft=0;
            int numARight=length-1;
            int numBRight=length-1;
            int count=0;
            while (numALeft<=numARight){
                if(numA[numARight]>numB[numBRight]){
                    count++;
                    numARight--;
                    numBRight--;
                }else if(numA[numARight]<numB[numBRight]){
                    count--;
                    numALeft++;
                    numBRight--;
                }else {
                    if(numA[numALeft]>numB[numBLeft]){
                       count++;
                        numALeft++;
                        numBLeft++;
                    }
            /*        else{
                        if(numA[numALeft]<numB[numBRight]){
                            count--;
                        }
                        numALeft++;
                        numBRight--;

                    }*/
                    else if(numA[numALeft]==numB[numBLeft]){
                       if(numA[numALeft]<numB[numBRight]){
                           count--;
                       }
                       numALeft++;
                       numBRight--;
                    }else {


                        numALeft++;
                        numBRight--;
                    }

                    }
            }
            System.out.println(count);

        }
    }
}
