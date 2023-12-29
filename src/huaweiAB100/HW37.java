package huaweiAB100;

import java.util.Scanner;

public class HW37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int sum = in.nextInt();
            System.out.println(getCount(sum, 0));
            System.out.println(getCount2(sum));
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
    public static int getCount2(int sum){
        if(sum==1){
            return 0;
        }
        if(sum%2==0){
            return     getCount2(sum/2)+1;
        }
        return Math.min(getCount2(sum+1),getCount2(sum-1))+1;
    }


}
