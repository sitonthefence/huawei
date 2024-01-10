package huaweiC100;

import java.util.Scanner;

public class HW17 {
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         int[] arr =new int[10];
         int allSum=0;
        for (int i = 0; i < 10; i++) {
            arr[i]=in.nextInt();
            allSum+=arr[i];
        }
        dfs(arr,0,0,allSum,0);
        System.out.println(min);
    }
    public static void dfs( int[] arr,int begin,int sum, int allSum,int count){

        if(count==5){
            min=Math.min(Math.abs(allSum-2*sum),min);
            return;
        }
        for (int i = begin; i <arr.length ; i++) {
            sum+=arr[i];
            dfs(arr,i+1,sum,allSum,count+1);
            sum-=arr[i];
        }


    }



}
