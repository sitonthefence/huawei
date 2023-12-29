package huaweiAB100;

import java.util.Scanner;

public class HW47 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]= in.nextInt();
            }
            boolean[] boolArray=new boolean[(arr.length-1)*100];
            for (int i = 0; i < length; i++) {
                int left=Math.max(i*100-arr[i],0);
                 int right=Math.min(i*100+arr[i],boolArray.length);
                for (int j = left; j < right; j++) {
                    boolArray[j]=true;
                }
            }
            int count=0;
            for (int i = 0; i < boolArray.length; i++) {
                if(boolArray[i]==false)
                    count++;
            }
            System.out.println(count);


        }


    }
}
