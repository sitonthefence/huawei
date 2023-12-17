package huawei100;

import java.util.Scanner;

public class HW37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int sum = in.nextInt();
            System.out.println(getCount(sum, 0));

        }


    }
    public static int getCount(int sum,int count){
        if(sum==1){
            return count;
        }
        if(sum%2==0){
         return     getCount(sum/2,count+1);
        }
        return Math.min(getCount(sum+1,count+1),getCount(sum-1,count+1));
    }

}
