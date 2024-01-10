package huaweiC100;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            int[] arr=new int[source.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=source.charAt(i)-'0';
            }
            int count =0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==0){
                    if((i==0||arr[i-1]==0)&&(arr.length-1==0||arr[i+1]==0)){
                      arr[i]=1;
                      count++;
                    }
                }

            }
            System.out.println(count);

        }
    }
}
