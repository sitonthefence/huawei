package huaweiC200;

import java.util.Scanner;

public class HW39THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arr=new int[length];
        for (int i = 0; i <length ; i++) {
            arr[i]=in.nextInt();
        }
        int length1 = in.nextInt();
        int length2=length-length1;
        int sum=0;
        int all=0;
        for (int i = 0; i < arr.length; i++) {
            all+=arr[i];
        }
        for (int i = 0; i <length2 ; i++) {
            sum+=arr[i];
        }
        int min=sum;
        for (int i = 1; i <length-length2+1 ; i++) {
            //注意
            sum-=arr[i-1];
            sum+=arr[i+length2-1];
            min=Math.min(sum,min);
        }
        System.out.println(all-min);



    }
}
