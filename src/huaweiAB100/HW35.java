package huaweiAB100;

import java.util.Scanner;

public class HW35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            Integer target = Integer.valueOf(in.nextLine());
            int[] arr=new int[split.length];
            int count=0;
            for (int i = 0; i < arr.length; i++) {
                if(Integer.valueOf(split[i])<target){
                    arr[i]=1;
                    count++;
                }
            }
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < arr.length-count+1; i++) {
                int sum=0;
                for (int j = 0; j <count  ; j++) {
                    sum=sum+arr[j];
                }
                max=Math.max(max,sum);
            }
            System.out.println(count-max);




        }

    }


}
