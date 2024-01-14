package huaweiC200;



import java.util.Scanner;

public class HW6 {
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] arr = new int[length];
            int sum=0;
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
                sum+=arr[i];
            }
            if(sum%2==1){
                System.out.println(-1);
                continue;
            }
            int target=sum/2;
            dfs(0,target,arr,0,0);
            if(min==Integer.MAX_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(min);
            }
        }
    }
    public static void dfs(int currentSum,int target,int[] arr,int begin,int count){
        if(currentSum>target){
            return;
        }
        if(currentSum==target){
            min=Math.min(min,count);
            return;
        }
        for (int i = begin; i <arr.length ; i++) {
          currentSum+=arr[i];
          dfs(currentSum,target,arr,begin+1,count+1);
         currentSum-=arr[i];
        }
    }

}
