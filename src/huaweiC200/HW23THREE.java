package huaweiC200;


import java.util.Arrays;
import java.util.Scanner;

public class HW23THREE {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        Integer[] arr =new Integer[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.valueOf(split[i]);
        }
        Arrays.sort(arr,(o1,o2)->o2-o1);
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            max=Math.max(max,arr[i]);
        }
        int person = in.nextInt();
        int[] bucket=new int[person];
        int left=max;
        int right=sum;
        int target=right;
        while (left<right){
            int mid=(left+right)/2;
            if(dfs(bucket,mid,0,arr)){
                right=mid;
                target=mid;
            }else {
                left=mid+1;
            }
        }
        System.out.println(target);

    }
    public static boolean dfs(int[] bucket,int mid,int index,Integer[] arr){
        if(index==arr.length){
            return true;
        }
        for (int i = 0; i <bucket.length ; i++) {
            if(bucket[i]+arr[i]<=mid){
                bucket[i]+=arr[i];
                if(dfs(bucket,mid,index+1,arr)) return true;
                bucket[i]-=arr[i];
            }


        }
        return false;





    }


}
