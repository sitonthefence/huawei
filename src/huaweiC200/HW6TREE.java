package huaweiC200;

import java.util.Scanner;

public class HW6TREE {
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr=new int[num];
        int sum=0;
        for (int i = 0; i < num; i++) {
            arr[i]=in.nextInt();
            sum+=arr[i];
        }
        if(sum%2!=0){
            System.out.println(-1);
            return;
        }

        int target=sum/2;
        dfs(0,0,0,target,arr);
        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(min);


    }
    public static void dfs(int count,int begin,int currentSum,int target,int[] arr){
        if(currentSum==target){
            min=Math.min(min,count);
            return;
        }
        if(currentSum>target||begin==arr.length){
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            currentSum+=arr[i];
            dfs(count+1,i+1,currentSum,target,arr);
            currentSum-=arr[i];

        }

    }




}
