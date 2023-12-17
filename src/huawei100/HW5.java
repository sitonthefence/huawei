package huawei100;

import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
           int target=-1;
           if(split.length==1){
               target=0;
           }


            for (int i = 0; i < split.length; i++) {
                int sum1=0;
                int sum2=0;
                for (int j = 0; j < i; j++) {
                     sum1=sum1+Integer.valueOf(split[j]);

                }
                for (int k = i+1; k < split.length; k++) {
                    sum2=sum2+Integer.valueOf(split[k]);

                }
                if(sum1==sum2){
                    target=i;
                    break;
                }


            }
            System.out.println(target);


        }
    }
}
