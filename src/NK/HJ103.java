package NK;

import java.util.Arrays;

import java.util.Scanner;
//3 1 3 1 2 1
public class HJ103 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int [] arr=new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=in.nextInt();
        }
        int [] K=new int[length];
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if(arr[i]<arr[j]){
                    K[j]=Math.max(K[i]+1,K[j]);
                }
            }
        }
        Arrays.sort(K);
        System.out.println(K[length-1]+1);

    }

}
