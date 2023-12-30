package huaweiC100;

import java.util.Scanner;

public class HW75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        boolean[]arr =new boolean[100];
        boolean flag=true;
        while(in.hasNextInt()){


            int start = in.nextInt();
            int length= in.nextInt();
            if(start<0||length+start-1>=99||length<0||start>=99){
             flag=false;
            }
            for (int i = start; i <start+length ; i++) {
                if (arr[i]==true){
                    flag=false;
                }
                 arr[i]=true;
            }
        }

       int left=0;
        int right=0;
        int currentLength=0;
        int minlength=Integer.MAX_VALUE;
        int minIndex=-1;

     while (right<99){
         if(arr[right]==true){
             currentLength=right-left;
             if(currentLength>=target&&currentLength<minlength){
                 minlength=currentLength;
                 minIndex=left;
             }
             left=right+1;
         }
         right++;
     }
     if(arr[right]==true){
         currentLength=right-left;
         if(currentLength>=target&&currentLength<minlength){
             minlength=currentLength;
             minIndex=left;
         }
     }else {
         currentLength=right-left+1;
         if(currentLength>=target&&currentLength<minlength){
             minlength=currentLength;
             minIndex=left;
         }
     }
     if(flag==false){
         System.out.println("-1");
         return;
     }

        System.out.println(minIndex);





    }
}
