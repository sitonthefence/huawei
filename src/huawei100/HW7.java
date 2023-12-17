package huawei100;


import java.util.Scanner;

public class HW7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int lengthA = in.nextInt();
            int lengthB = in.nextInt();
            int R=in.nextInt();
            int[] m=new int[lengthA];
            for (int i = 0; i < lengthA; i++) {
                m[i]=in.nextInt();
            }
            int[] n=new int[lengthB];
            for (int i = 0; i < lengthB; i++) {
                n[i]=in.nextInt();
            }

            for (int i = 0; i < lengthA; i++) {
                for (int j =0; j < lengthB; j++) {
                 if(n[j]-m[i]<=R&&m[i]<=n[j]){
                     System.out.println(m[i]+" "+n[j]);
                     break;

                 }

                }
            }

            }


        }


    }


