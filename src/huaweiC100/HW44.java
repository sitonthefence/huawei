package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            int [] arr=new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            int [] result=new int[split.length];
            for (int i = 0; i <split.length ; i++) {
                 if(i==0){
                     result[0]=Math.max(arr[0],0);
                 }
                 if(i==1){
                     result[1]=Math.max(result[0]+arr[1],0);
                 }
                 if(i==2){
                     result[2]=Math.max(result[1]+arr[2],0);
                 }
                 if(i>=3){
                     result[i]=Math.max(result[i-1]+arr[i],arr[i-3]);
                 }
            }
            System.out.println(result[split.length-1]);

        }


    }
}
