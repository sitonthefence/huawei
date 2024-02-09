package huaweiC100;


import java.util.Arrays;
import java.util.Scanner;

public class HW34THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[]  arr=new int[length+1];
      int[]  family=new int[length+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i]=in.nextInt();
            family[i]=arr[i];

        }
        for (int i = 0; i <length-1 ; i++) {
            int a = in.nextInt();
            int b= in.nextInt();
  //          arr[a]+=arr[b];
            family[a]+=arr[b];

        }

        System.out.println(Arrays.stream(family).max().orElse(0));

    }
}
