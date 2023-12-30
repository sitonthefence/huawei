package huaweiC100;

import java.util.Scanner;

public class HW23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            if(split.length>8){
                System.out.println(-1);
                break;
            }
            int [] arr=new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max=Math.max(max,arr[i]);
            }
            int left=0;
            int right=max;
            int result=max;
            while (left<right){
                 int middle=(left+right)/2;
                if(getTime(middle,arr)<=8){
                   result=middle;
                    right=middle;
                }else {
                    left=middle+1;
                }


            }
            System.out.println(result);




        }

    }
    public static int getTime(int speed,  int [] arr){
        int time=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%speed==0){
                time+=(arr[i]/speed);
            }else {
                time+=(arr[i]/speed)+1;
            }
        }
        return time;



    }
}
