package huaweiAB100;

import java.util.Arrays;
import java.util.Scanner;

public class HW43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){

            int length = in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i < length; i++) {
                  arr[i]=in.nextInt();
            }
            Arrays.sort(arr);
            int flag=0;
            for (int i = 0; i <arr.length-2 ; i++) {
                for (int j = i+1; j < arr.length-1; j++) {
                    for (int k = j+1; k < arr.length; k++) {
                      if(arr[i]+2*arr[j]==arr[k]){
                          System.out.println(arr[k]+" "+arr[i]+" "+arr[j]);
                          flag=1;
                          break;
                      }
                        if(2*arr[i]+arr[j]==arr[k]){
                            System.out.println(arr[k]+" "+arr[j]+" "+arr[i]);
                            flag=2;
                            break;
                        }

                    }
                }
            }
            if(flag==0){
                System.out.println(0);
            }



        }


    }
}
